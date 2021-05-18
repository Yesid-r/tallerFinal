package control;

import model.Management;

public class Control {
    private Management management;

    public Control() {
        this.management = new Management();
    }
    public boolean verifyUser(String[]data){
        switch (data[2]){
            case "Docente":{
                for (int i = 0; i < management.getTeachers().size(); i++) {
                    if (management.getTeachers().get(i).getUser().equals(data[0]) && management.getTeachers().get(i).getPassword().equals(data[1])){
                        return true;
                    }

                }
            }
            break;
        }
        return false;
    }
}
