package com.learning.medicalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.learning.medicalapp.utility.Constants;
import com.learning.medicalapp.utility.FileUtil;
import com.learning.medicalapp.utility.Utils;
import com.learning.medicalapp.model.UserProfile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String mResult = "";
    private HashMap<UserProfile, String> mFileContent = new HashMap<>();
    private Button mButtonSave, mButtonShow;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        String combinedUserList = FileUtil.readContentFromFile(Constants.FILE1) + FileUtil.readContentFromFile(Constants.FILE2);
        String[] values = combinedUserList.split("\n");

        for (int index = 0; index < values.length; index++) {
            String[] column = values[index].split("\t");
            mFileContent.put(new UserProfile(column[0], column[1]),
                    Utils.getUserType(Utils.hexToBin(column[2].toUpperCase(Locale.ROOT))));
        }

        for (Map.Entry<UserProfile, String> map : mFileContent.entrySet()) {
            mResult += map.getKey().getUserId() + "\t" + map.getKey().getDeviceId() + "\t" + map.getValue() + "\n";
        }


    }

    /**
     * Initializing EditText, Buttons and TextViews from the layout file
     */
    private void initView() {
        mButtonSave = findViewById(R.id.saveButton);
        mButtonSave.setOnClickListener(this);
        mButtonShow = findViewById(R.id.showButton);
        mButtonShow.setOnClickListener(this);
        mTextView = findViewById(R.id.text_view);
    }

    @Override
    public void onClick(View view) {
        // Save Button will generate DeviceUserListUpdated.txt file with all updated contents
        if (view.getId() == R.id.saveButton) {
            if (!mResult.isEmpty()) {
                FileUtil.writeDeviceUserList(Constants.FILE3,mResult);
            } else {
                Toast.makeText(getApplicationContext(), "No input?", Toast.LENGTH_SHORT).show();
            }

        } else if (view.getId() == R.id.showButton) {
            // Show button will display DeviceUserListUpdated.txt file content
            mTextView.setText(mResult);
        }
    }
}



