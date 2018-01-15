
public class WeatherIcons {
    private String[] icons = {"\uD83D\uDC36","\uD83D\uDC31","\uD83D\uDC2D","\uD83D\uDC39","\uD83D\uDC30",
            "\uD83E\uDD8A","\uD83D\uDC3B","\uD83D\uDC3C","\uD83D\uDC28","\uD83D\uDC2F","\uD83E\uDD81","\uD83D\uDC2E",
            "\uD83D\uDC37","\uD83D\uDC3D","\uD83D\uDC38","\uD83D\uDC35"};

    public String getIcon(){
        int randomNum = (int)(Math.random()*16);
        return icons[randomNum];
    }
}
