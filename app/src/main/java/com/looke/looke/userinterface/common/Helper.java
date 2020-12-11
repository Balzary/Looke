package com.looke.looke.userinterface.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.looke.looke.R;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helper
{
    public static String formatarDataPaginacao(Date pData)
    {
        Calendar cal = Calendar.getInstance();
// remove next line if you're always using the current time.
        cal.setTime(pData);
        cal.add(Calendar.SECOND, 5);
        pData = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(pData);
    }

    public static void showToast(Activity pContexto, String pMensagem)
    {
        Toast toast = new Toast(pContexto);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, 0);
        toast.show();
    }

}
