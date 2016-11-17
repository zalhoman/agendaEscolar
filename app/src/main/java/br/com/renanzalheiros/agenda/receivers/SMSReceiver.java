package br.com.renanzalheiros.agenda.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

import br.com.renanzalheiros.agenda.dao.AlunoDAO;

/**
 * Created by andrepereira on 13/11/16.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        byte[] pdu = (byte[]) pdus[0];

        String formato = (String) intent.getSerializableExtra("format");

        SmsMessage sms = SmsMessage.createFromPdu(pdu, formato);

        String telefone = sms.getDisplayOriginatingAddress();
        AlunoDAO dao = new AlunoDAO(context);
        if(dao.ehAluno(telefone)){
            Toast.makeText(context, "Chegou SMS!", Toast.LENGTH_LONG).show();

            // para adicionar um som diferente ao receber a mensagem:
            // MediaPlayer mp = MediaPlayer.create(context, R.raw.msg);
            // mp.start();
        }
        dao.close();
    }
}
