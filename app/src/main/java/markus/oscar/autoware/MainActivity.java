package markus.oscar.autoware;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.ros.address.InetAddressFactory;
import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class MainActivity extends RosActivity {

    public MainActivity() {
        super("AutowareTouch", "AutowareTouch");
    }

    protected MainActivity(String notificationTicker, String notificationTitle) {
        super(notificationTicker, notificationTitle);
    }

    protected MainActivity(String notificationTicker, String notificationTitle, URI customMasterUri) {
        super(notificationTicker, notificationTitle, customMasterUri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(InetAddressFactory.newNonLoopback().getHostAddress());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeConfiguration.setNodeName("autoware_touch");

        AutowareTouch autoware_touch = new AutowareTouch(this);
        nodeMainExecutor.execute(autoware_touch, nodeConfiguration);

    }

    public void startDigitalHandle(String data) {
     //   new setDigitalHandle().execute(Looper.getMainLooper(), data);
    }

    public void startGasHandle(String data) {
      //  new setGasHandle().execute(Looper.getMainLooper(), data);
    }

    public void startBrakeHandle(String data) {
    //    new setBrakeHandle().execute(Looper.getMainLooper(), data);
    }

    public void startConnHandle(String data) {
     //   new setConnHandle().execute(Looper.getMainLooper(), data);
    }

    public void startTwistHandle(String data) {
     //   new setTwistHandle().execute(Looper.getMainLooper(), data);
    }

    public void startCanSpeedHandle(String data) {
      //  new setCanSpeedHandle().execute(Looper.getMainLooper(), data);
    }

    public void startCanBrakepedalHandle(String data) {
    //    new setCanBrakepedalHandle().execute(Looper.getMainLooper(), data);
    }

    public void startCanAngleHandle(String data) {
    //    new setCanAngleHandle().execute(Looper.getMainLooper(), data);
    }

    public void startModeHandle(String data) {
    //    new setModeHandle().execute(Looper.getMainLooper(), data);
    }
}
