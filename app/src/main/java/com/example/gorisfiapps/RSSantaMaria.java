package com.example.gorisfiapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSSantaMaria extends ListActivity {
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center", "Driving Direction", "Website", "Info Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter(). getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center"))
            {
                String nomortel = "tel: 0811-7603000";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));
            }else if (pilihan.equals("Rumah Sakit Santa Maria"))
            {
                a = new Intent(this,RSSantaMaria.class);
                startActivity(a);
            }else if (pilihan.equals("SMS Center"))
            {
                String smsText="Risfi Ayu Sandika/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:08117603000"));
                a.putExtra ("sms_body", smsText);
            }else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs = "https://goo.gl/maps/6rMBKJFz9zAv7kTs5";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            }else if (pilihan.equals("Website")){
                String website = "http://www.rssantamariapekanbaru.com/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            }else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Santa Maria");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
