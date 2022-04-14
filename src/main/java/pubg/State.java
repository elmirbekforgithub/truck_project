package pubg;

import java.util.Random;

public enum State {
    BASE("base"){
        @Override
        public void changeDriver(Auto auto, Driver[] driver) {
            int count=0;
            for (int i = 0; i <driver.length ; i++) {
                if(driver[i].getBus()!=null){
                    count++;
                }
            }
            auto.setDriver(driver[count].getName());
            driver[count].setBus(auto.getAutoName());
        }

        @Override
        public void startDriving(Auto auto) throws Exception {
            if(auto.getDriver().equals("")){
                throw new Exception();
            }else {
                auto.setState(State.ROUTE);
                System.out.println("успешно вышли на маршруt");
            }
        }

        @Override
        public void startRepair(Auto auto) {
            auto.setState(State.REPAIR);
            System.out.println("repair");
        }
    },
    ROUTE("route") {
        @Override
        public void changeDriver(Auto auto, Driver[] driver) throws Exception {
            throw new Exception("Грузовик в пути, невозможно сменить водителя");
        }

        @Override
        public void startDriving(Auto auto) throws Exception {
            throw new Exception();
        }

        @Override
        public void startRepair(Auto auto) throws Exception {
            auto.setState(State.REPAIR);
            System.out.println("repair");
        }
    },
    REPAIR("repair") {
        @Override
        public void changeDriver(Auto auto, Driver[] driver) throws Exception {
            throw new Exception();
        }

        @Override
        public void startDriving(Auto auto) {
            Random random = new Random();
            int randomNum = random.nextInt(2);
            if(randomNum==0){
                auto.setState(State.BASE);
                System.out.println();
            }else {
                auto.setState(State.ROUTE);
                System.out.println();
            }
        }

        @Override
        public void startRepair(Auto auto) throws Exception {
            throw new Exception();
        }
    };
    private String state;
    State(String state) {
        this.state = state;
    }
    public abstract void changeDriver(Auto auto, Driver[] driver) throws Exception;
    public abstract void startDriving(Auto  auto) throws Exception;
    public abstract void startRepair(Auto auto) throws Exception;

}
