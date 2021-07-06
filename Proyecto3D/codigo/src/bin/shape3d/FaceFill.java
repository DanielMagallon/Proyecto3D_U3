package bin.shape3d;

public enum FaceFill
{
    NONE(-1),
    NORMAL(0),
    GRADIENT(1),
    IMAGE(2);

    private int fill;
    FaceFill(int v)
    {
        fill=v;
    }
}
