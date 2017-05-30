package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private final String LOGIN = "HENRIQUE";
    private final String SENHA = "1234";

    private TextInputLayout tilLogin;
    private TextInputLayout tilSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tilLogin = (TextInputLayout) findViewById(R.id.tilLogin);
        tilSenha = (TextInputLayout) findViewById(R.id.tilSenha);
    }

    public void logar(View view) {
        boolean loginValido;
        boolean senhaValida;
        String login = tilLogin.getEditText().getText().toString();
        String senha = tilSenha.getEditText().getText().toString();
        if(!login.equalsIgnoreCase(LOGIN)){
            tilLogin.setError(getString(R.string.msg_login_invalido));
            loginValido = false;
        }else{
            tilLogin.setError(null);
            loginValido = true;
        }
        if(!senha.equalsIgnoreCase(SENHA)){
            tilSenha.setError(getString(R.string.msg_senha_invalida));
            senhaValida =false;
        }else{
            tilSenha.setError(null);
            senhaValida =true;
        }

        if(loginValido && senhaValida){
            Intent intent = new Intent(this,
                    PedidoActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
        }
    }
}
