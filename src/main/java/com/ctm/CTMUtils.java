package com.ctm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ctm.domain.Talk;

/**
 * Utitlity class
 *
 * @author Kishor
 */
public class CTMUtils {

	private static final String LIGHTNING = "";
	private static final int LIGHTNING_DURATION = 0;

	private CTMUtils() {

    }

    public static List<Talk> getTalksFromFile(File talkFile)
            throws NumberFormatException, IOException {

        List<Talk> talkList = new ArrayList<Talk>();
        BufferedReader talkFileBuffer = new BufferedReader(new FileReader(talkFile));

        String talkDescription = null;

        while ((talkDescription = talkFileBuffer.readLine()) != null) {
            int duration = 0;
            String[] stringArray = talkDescription.split(" ");
            String durationStirng = stringArray[stringArray.length - 1]
                    .toLowerCase();
            if (durationStirng.matches(LIGHTNING)) {
                duration = LIGHTNING_DURATION;
            } else if (durationStirng.contains("min")) {
                durationStirng = durationStirng.substring(0,
                        durationStirng.indexOf('m'));
                duration = Integer.parseInt(durationStirng);
            } else {
                System.out.println("Invalid talk present in the file. Talk description: " + talkDescription);
                continue;
            }

            Talk talk = new Talk(talkDescription, duration);
            talkList.add(talk);
        }
        talkFileBuffer.close();

        return talkList;
    }

    public static String printTalks(StringBuilder response, List<Talk> talks) {
        for (Talk t : talks) {
            response.append(t.getStartTime().toString() + " " + t.getName() + " \n");
        }
        return response.toString();
    }


}
