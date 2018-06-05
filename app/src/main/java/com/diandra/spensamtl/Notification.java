package com.diandra.spensamtl;

public class Notification {
    private String notifId;
    private String notifJudul;
    private String notifPengumuman;

    public Notification(){

    }

    public Notification(String notifId, String notifJudul, String notifPengumuman) {
        this.notifId = notifId;
        this.notifJudul = notifJudul;
        this.notifPengumuman = notifPengumuman;
    }

    public String getNotifId() {
        return notifId;
    }

    public String getNotifJudul() {
        return notifJudul;
    }

    public String getNotifPengumuman() {
        return notifPengumuman;
    }
}
