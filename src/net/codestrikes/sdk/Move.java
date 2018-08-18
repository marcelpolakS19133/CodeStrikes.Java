package net.codestrikes.sdk;

public class Move
{
    private MoveType type;
    private Area area;

    public MoveType getType() {
        return type;
    }

    public Area getArea() {
        return area;
    }

    public int getAttackPower() {
        switch (area)
        {
            case HookKick: return 10;
            case HookPunch: return 6;
            case UppercutPunch: return 3;
            case LowKick: return 1;
        }
        return 0;
    }

    public int getEnergy() {
        if (type == MoveType.Attack)
        {
            switch (area)
            {
                case HookKick: return 4;
                case HookPunch: return 3;
                case UppercutPunch: return 2;
                case LowKick: return 1;
            }
        }
        // Defense
        else
        {
            return 4;
        }
        return 0;
    }

    public Move(MoveType type, Area area)
    {
        this.type = type;
        this.area = area;
    }
}
