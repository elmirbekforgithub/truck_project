package pubg;

public class Auto {
    private int id ;
    private String autoName;
    private String driver;
    private State state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoName() {
        return autoName;
    }

    public void setAutoName(String autoName) {
        this.autoName = autoName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String name) {
        this.driver = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void print(Auto[] autos) {
        System.out.println("---------------TRUCKS-----------------");
        System.out.println("#  |    Bus        |  Driver  |  State ");
        System.out.println("———+———————————————+——————————+————————");
        for (int i = 0; i < autos.length; i++) {
            System.out.printf("%-3s|", autos[i].getId());
            System.out.printf("%-15s|", autos[i].getAutoName());
            System.out.printf("%-10s|", autos[i].getDriver());
            System.out.printf("%-7s|", autos[i].getState());
            System.out.println();
        }
    }

    public static void injection() {
        System.out.println("press 1 to change driver");
        System.out.println("press 2 to start driving");
        System.out.println("press 3 to start repair ");
    }

    public static void getInfo(Auto auto) {
        System.out.println("---------------TRUCK-INF----------------");
        System.out.printf("N" + "%12s", ":" + auto.getId() + "\n");
        System.out.printf("Bus" + "%23s", ":" + auto.getAutoName() + "\n");
        System.out.printf("Driver" + "%6s", ":" + auto.getDriver() + "\n");
        System.out.printf("Bus State" + "%7s", ":" + auto.getState() + "\n");
    }
    //
    public static void action(String action, Auto auto, Driver[] drivers)  {
        switch (action) {
            case "1":
                if (auto.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.changeDriver(auto,drivers);
                    } catch (Exception e) {
                        System.out.println("U truckta netu voditelya");
                    }
                } else if (auto.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.changeDriver(auto,drivers);
                    } catch (Exception e) {
                        System.out.println("Грузовик в пути, невозможно сменить водителя");
                    }
                } else {
                    State repair = State.REPAIR;
                    try {
                        repair.changeDriver(auto,drivers);;
                    } catch (Exception e) {
                        System.out.println("Нельзя сменить водителя");
                    }

                }
                break;
            case "2" :
                if (auto.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.startDriving(auto);
                    } catch (Exception e) {
                        System.out.println("Грузовикa netu voditelya");
                    }
                } else if (auto.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.startDriving(auto);
                    } catch (Exception e) {
                    }
                } else {
                    State repair = State.REPAIR;
                    try {
                        repair.startDriving(auto);
                    } catch (Exception e) {
                        System.out.println();
                    }
                }
                break;
            case "3" :
                if (auto.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.startRepair(auto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (auto.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.startRepair(auto);
                    } catch (Exception e) {
                        System.out.println();
                    }
                } else {
                    try {
                        State repair = State.REPAIR;
                        repair.startRepair(auto);
                    } catch (Exception e) {
                        System.out.println("uje v remonte");
                    }
                }
                break;
            default:
                System.out.println();
        }
    }
}


