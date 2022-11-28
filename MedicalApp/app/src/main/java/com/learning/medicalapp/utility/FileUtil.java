package com.learning.medicalapp.utility;

import android.widget.Toast;

import com.learning.medicalapp.BaseApplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class FileUtil {

    /**
     * Write updated file(DeviceUserListUpdated.txt)
     * Generated filepath-> /data/data/com.learning.medicalapp/files/DeviceUserListUpdated.txt
     */
    public static String writeDeviceUserList(String file,String result) {
        try {
            FileOutputStream fileout = BaseApplication.getInstance().openFileOutput(file, MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(result);
            outputWriter.close();
            //display file saved message
            Toast.makeText(BaseApplication.getInstance(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Read DeviceUserList.txt and PortalUserList.txt file
     *
     * @return -> contents of file
     */
    public static String readContentFromFile(String file) {
        String contents = "";
        try {
            InputStream stream = BaseApplication.getInstance().getAssets().open(file);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            contents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        return contents;
    }
}
