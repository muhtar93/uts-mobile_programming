package id.ac.stmikim.muhtar_361661001;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.editTextUsername)
    EditText editTextUsername;
    @InjectView(R.id.editTextPassword)
    EditText editTextPassword;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Form Login");
    }

    @OnClick(R.id.buttonLogin)
    public void onClickButtonLogin() {
        if (editTextUsername.getText().toString().equals("361661001") && editTextPassword.getText().toString().equals("Muhtar")) {
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setMessage("Selamat ID dan Password Anda sudah benar");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            editTextUsername.setText("");
            editTextPassword.setText("");
        } else if (editTextUsername.getText().toString().length() == 0){
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setMessage("Anda belum memasukan ID");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if (editTextPassword.getText().toString().length() == 0){
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setMessage("Anda belum memasukan Password");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else {
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setMessage("Maaf ID dan Password Anda salah, silahkan ulangi");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            editTextUsername.setText("");
            editTextPassword.setText("");
        }
    }

    @OnClick(R.id.buttonExit)
    public void onClickButtonExit(){
        finish();
    }
}
