package app.dirrehum.aguila6;

public class ScreenItem {
    String Intro, Tex;
    int ScreenImg;

    public ScreenItem(String intro, String tex, int screenImg) {
        Intro = intro;
        Tex = tex;
        ScreenImg = screenImg;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public void setTex(String tex) {
        Tex = tex;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public String getIntro() {
        return Intro;
    }

    public String getTex() {
        return Tex;
    }

    public int getScreenImg() {
        return ScreenImg;
    }
}
