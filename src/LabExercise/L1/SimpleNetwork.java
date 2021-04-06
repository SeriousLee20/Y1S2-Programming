package LabExercise.L1;

/*
 * Author: Hui Xin
 * 17 Feb 2021
 */

public class SimpleNetwork {
    private String hostName;
    private String IP;
    private String subnetMask;
    private String status;

    public SimpleNetwork(String hostName, String IP, String subnetMask, String status) {
        this.hostName = hostName;
        this.IP = IP;
        this.subnetMask = subnetMask;
        this.status = status;
    }

    public void ping(SimpleNetwork sn) {
        if (this.status == "DOWN" || sn.status == "DOWN") {
            System.out.println(this.hostName + " cannot ping " + sn.hostName + (this.status == "DOWN" ?
                            "because the destination " + this.hostName + " is down." :
                            " because the destination " + sn.hostName + " is down."));
        } else if (!this.IP.equals(sn.IP)) {
            System.out.println(this.hostName + " cannot ping " + sn.hostName +
                    " because the destination " + sn.hostName + " is located in different network.");
        } else if(this.subnetMask.equals(sn.subnetMask)) {
            System.out.println(this.hostName + " can ping " + sn.hostName + ".");
        }
    }
}
