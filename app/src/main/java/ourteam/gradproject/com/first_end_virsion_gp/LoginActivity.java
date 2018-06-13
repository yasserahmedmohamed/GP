package ourteam.gradproject.com.first_end_virsion_gp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.user_id)
    EditText user_id;
    @BindView(R.id.password)
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.setTransparent(this);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.login)
    public void login(){
        //change it with validation()
        if (true){
            Intent intent =new Intent(this,MainActivity.class);
            startActivity( intent);
        }
    }

    public boolean validation(){
        user_id.clearFocus();
        password.clearFocus();
        String suserid=user_id.getText().toString();
        String userpassword=password.getText().toString();

        if (suserid.length()<14){
            user_id.setError("من فضلك ادخل رقم قومي صحيح");
            user_id.requestFocus();
            return false;
        }
        if (suserid.isEmpty()){
            user_id.setError("من فضلك ادخل رقمك قومي ");
            user_id.requestFocus();
            return false;
        }
        if (userpassword.length()<10){
            password.setError("اقل من 10 ارقام");
            password.requestFocus();
            return false;
        }
        if (userpassword.isEmpty()){
            password.setError("من فضلك ادخل الرقم السري");
            password.requestFocus();
            return false;
        }
        return true;
    }
}
