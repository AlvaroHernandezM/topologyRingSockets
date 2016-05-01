package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import logic.*;

public class ActionListenerApp implements ActionListener{

	public static final String COMMAND_ACCEPT_CONFIGURATION = "ACEPTAR";

	private JPanelConfigurationTopology configurationTopology;
    private JFrameApp jFrameApp;
    private RunShell shell;
    private ConexionSSH conexion;
    private Thread threadConexion;

	public ActionListenerApp(){
		super();
	}

	@Override
    	public void actionPerformed(ActionEvent e) {
    		String commandCase = e.getActionCommand();
    		switch(commandCase){
    			case COMMAND_ACCEPT_CONFIGURATION:
                this.configurationTopology.setVisible(false);
                this.jFrameApp.addJPanelShowInformation(this.configurationTopology.getHostNode1(), this.configurationTopology.getHostNode2(), this.configurationTopology.getHostNode3(), this.configurationTopology.getHostNode4());
                /*
                    Message myIp = new Message();
    				boolean isNode1 = myIp.getMyIp().equals(this.configurationTopology.getHostNode1());
                    boolean isNode2 = myIp.getMyIp().equals(this.configurationTopology.getHostNode2());
                    boolean isNode3 = myIp.getMyIp().equals(this.configurationTopology.getHostNode3());
                    boolean isNode4 = myIp.getMyIp().equals(this.configurationTopology.getHostNode4());
                    String password = "cc1052407351";
                    if(isNode1){
                        this.shell = new RunShell("java main/MainApp "+this.configurationTopology.getHostNode2()+" "+myIp.getMyIp().equals(this.configurationTopology.getServerData()));
                        this.threadConexion = new Thread(this.shell);
                        this.threadConexion.start();

                    } else {
                        String command = "cd testJava/topologyRingWithSockets/; java main/MainApp "+this.configurationTopology.getHostNode2()+" "+this.configurationTopology.getHostNode1().equals(this.configurationTopology.getServerData());
                        this.conexion = new ConexionSSH(this.configurationTopology.getHostNode1(), this.configurationTopology.getUserNode1(), password, command);
                        this.threadConexion = new Thread(this.conexion);
                        this.threadConexion.start();
                    }
                    if(isNode2){
                        this.shell = new RunShell("java main/MainApp "+this.configurationTopology.getHostNode3()+" "+myIp.getMyIp().equals(this.configurationTopology.getServerData()));
                        this.threadConexion = new Thread(this.shell);
                        this.threadConexion.start();
                    } else {
                        String command2 = "cd testJava/topologyRingWithSockets/; java main/MainApp "+this.configurationTopology.getHostNode3()+" "+this.configurationTopology.getHostNode2().equals(this.configurationTopology.getServerData());
                        this.conexion = new ConexionSSH(this.configurationTopology.getHostNode2(), this.configurationTopology.getUserNode2(), password, command2);
                        this.threadConexion = new Thread(this.conexion);
                        this.threadConexion.start();
                    }
                    if(isNode3){
                        this.shell = new RunShell("java main/MainApp "+this.configurationTopology.getHostNode4()+" "+myIp.getMyIp().equals(this.configurationTopology.getServerData()));
                        this.threadConexion = new Thread(this.shell);
                        this.threadConexion.start();
                    } else {
                        String command3 = "cd testJava/topologyRingWithSockets/; java main/MainApp "+this.configurationTopology.getHostNode4()+" "+this.configurationTopology.getHostNode3().equals(this.configurationTopology.getServerData());
                        this.conexion = new ConexionSSH(this.configurationTopology.getHostNode3(), this.configurationTopology.getUserNode3(), password, command3);
                        this.threadConexion = new Thread(this.conexion);
                        this.threadConexion.start();
                    }
                    if(isNode4){                    
                        this.shell = new RunShell("java main/MainApp "+this.configurationTopology.getHostNode1()+" "+myIp.getMyIp().equals(this.configurationTopology.getServerData()));
                        this.threadConexion = new Thread(this.shell);
                        this.threadConexion.start();
                    } else {
                        String command4 = "cd testJava/topologyRingWithSockets/; java main/MainApp "+this.configurationTopology.getHostNode1()+" "+this.configurationTopology.getHostNode4().equals(this.configurationTopology.getServerData());
                        this.conexion = new ConexionSSH(this.configurationTopology.getHostNode4(), this.configurationTopology.getUserNode4(), password, command4);
                        this.threadConexion = new Thread(this.conexion);
                        this.threadConexion.start();
                    }   
                    */
                    
                    /*				
    				System.out.println(this.configurationTopology.getHostNode1());
                    System.out.println(this.configurationTopology.getUserNode1());
                    
    				System.out.println(this.configurationTopology.getHostNode2());
                    System.out.println(this.configurationTopology.getUserNode2());

    				System.out.println(this.configurationTopology.getHostNode3());
                    System.out.println(this.configurationTopology.getUserNode3());

    				System.out.println(this.configurationTopology.getHostNode4());
                    System.out.println(this.configurationTopology.getUserNode4());
    				System.out.println(myIp.getMyIp().equals(this.configurationTopology.getServerData()));
                    System.out.println(this.configurationTopology.getNodeShow());
                    */
    			break;
    			default:
    			break;
    		}
	}

	public void setJPanelConfigurationTopology(JPanelConfigurationTopology configurationTopology){
		this.configurationTopology = configurationTopology;
	}

    public void setJFrameApp(JFrameApp jFrameApp){
        this.jFrameApp = jFrameApp;
    }

}
