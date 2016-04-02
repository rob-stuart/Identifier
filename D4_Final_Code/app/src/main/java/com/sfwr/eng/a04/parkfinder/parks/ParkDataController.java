package com.sfwr.eng.a04.parkfinder.parks;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.sfwr.eng.a04.parkfinder.R;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;

public class ParkDataController {
    private HashSet<Park> parkSet = null;

    public ParkDataController(Context context) {
        //TODO initialize parkSet
        createParkSet(decryptFile(context.getResources().openRawResource(R.raw.park_data)));

        // int i = 1;
        // for (Park foo : parkSet) {// test that they were made by printing their names
        // System.out.println(i++ + "\t" + foo);
        // }

    }

    public Set<Park> getParkSet() {
        return (HashSet<Park>) parkSet.clone();
    }

    private void createParkSet(InputStream in) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        parkSet = new HashSet<Park>(20);
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            NodeList parkList = doc.getFirstChild().getChildNodes();
            for (int i = 1; i < parkList.getLength(); i += 2) {
                NodeList parkAttributes = parkList.item(i).getChildNodes();
                Node nameNode = parkAttributes.item(1);
                if (nameNode.getFirstChild() == null) {
                    continue;
                }
                String parkName = nameNode.getFirstChild().getNodeValue();
                // System.out.println(parkName);

                Node sizeNode = parkAttributes.item(3);
                if (sizeNode.getFirstChild() == null) {
                    continue;
                }
                Double parkSize = Double.parseDouble(sizeNode.getFirstChild().getNodeValue());
                // System.out.println(parkSize);

                NodeList location = parkAttributes.item(5).getChildNodes();
                Node latitudeNode = location.item(1);
                if (latitudeNode.getFirstChild() == null) {
                    continue;
                }
                Double parkLatitude = Double.parseDouble(latitudeNode.getFirstChild().getNodeValue());
                // System.out.println(parkLatitude);

                Node longitudeNode = location.item(3);
                if (longitudeNode.getFirstChild() == null) {
                    continue;
                }
                Double parkLongitude = Double.parseDouble(longitudeNode.getFirstChild().getNodeValue());
                // System.out.println(parkLongitude);

                NodeList openDates = parkAttributes.item(7).getChildNodes();
                Node openDateNode = openDates.item(1);
                if (openDateNode.getFirstChild() == null) {
                    continue;
                }
                Date openDate = dateFormat.parse(openDateNode.getFirstChild().getNodeValue());
                // System.out.println(dateFormat.format(openDate));

                Node closeDateNode = openDates.item(3);
                if (closeDateNode.getFirstChild() == null) {
                    continue;
                }
                Date closeDate = dateFormat.parse(closeDateNode.getFirstChild().getNodeValue());
                // System.out.println(dateFormat.format(closeDate));

                Node URLNode = parkAttributes.item(9);
                if (URLNode.getFirstChild() == null) {
                    continue;
                }
                String parkURL = URLNode.getFirstChild().getNodeValue();
                // System.out.println(parkURL);

                Park park = new Park(parkName, parkSize, new LatLng(parkLatitude, parkLongitude),
                        new Pair<>(openDate, closeDate), parkURL);

                NodeList camps = parkAttributes.item(11).getChildNodes();
                NodeList campAttributes;
                Node campTypeNode;
                String campType;
                String campDesc;
                for (int j = 1; j < camps.getLength(); j += 2) {
                    campAttributes = camps.item(j).getChildNodes();
                    campTypeNode = campAttributes.item(1);
                    if (campTypeNode.getFirstChild() == null) {
                        campType = "Not Available";
                        campDesc = "";
                    } else {
                        campType = campTypeNode.getFirstChild().getNodeValue();
                        campDesc = campAttributes.item(3).getFirstChild().getNodeValue();
                    }
                    // System.out.println(campType);
                    // System.out.println(campDesc);
                    park.addCampType(campType, campDesc);
                }

                NodeList activities = parkAttributes.item(13).getChildNodes();
                NodeList activityAttributes;
                Node activityTypeNode;
                String activityType;
                String activityDesc;
                for (int j = 1; j < activities.getLength(); j += 2) {
                    activityAttributes = activities.item(j).getChildNodes();
                    activityTypeNode = activityAttributes.item(1);
                    if (activityTypeNode.getFirstChild() == null) {
                        activityType = "Not Available";
                        activityDesc = "";
                    } else {
                        activityType = activityTypeNode.getFirstChild().getNodeValue();
                        activityDesc = activityAttributes.item(3).getFirstChild().getNodeValue();
                    }
                    // System.out.println(activityType);
                    // System.out.println(activityDesc);
                    park.addActivity(activityType, activityDesc);
                }

                NodeList facilities = parkAttributes.item(15).getChildNodes();
                NodeList facilityAttributes;
                Node facilityTypeNode;
                String facilityType;
                String facilityDesc;
                for (int j = 1; j < facilities.getLength(); j += 2) {
                    facilityAttributes = facilities.item(j).getChildNodes();
                    facilityTypeNode = facilityAttributes.item(1);
                    if (facilityTypeNode.getFirstChild() == null) {
                        facilityType = "Not Available";
                        facilityDesc = "";
                    } else {
                        facilityType = facilityTypeNode.getFirstChild().getNodeValue();
                        facilityDesc = facilityAttributes.item(3).getFirstChild().getNodeValue();
                    }
                    // System.out.println(facilityType);
                    // System.out.println(facilityDesc);
                    park.addFacility(facilityType, facilityDesc);
                }
                parkSet.add(park);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream decryptFile(InputStream is) {
        byte[] iv = {58, 0, 107, -82, -128, 63, -96, -105, 46, 93, 16, 40, -84, 91, 56, -37};
        String algo = "AES", encoding = "UTF-8";
        ByteArrayInputStream bin = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algo);
            keyGenerator.init(new SecureRandom("nobodyCanBreakThisKey".getBytes(encoding)));
            Cipher cipher = Cipher.getInstance(algo + "/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, keyGenerator.generateKey(), new IvParameterSpec(iv));
            CipherInputStream in = new CipherInputStream(is, cipher);
            StringBuilder out = new StringBuilder();
            byte[] buffer = new byte[1024];
            int i;
            while (in.read(buffer) >= 0) {
                for (i = 0; i < buffer.length && buffer[i] != 0; i++) {
                }
                out.append(new String(buffer, 0, i, encoding));
            }
            bin = new ByteArrayInputStream(out.toString().getBytes());// removes trailing whitespace in initial input stream
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bin;
    }

}
