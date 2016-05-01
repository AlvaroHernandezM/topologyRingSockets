package test;


import logic.*;

    public class SSHCommandExecutor {
        /** * @param args */
        public static void main(String[] args) {
            String host = "192.168.0.21";
            String user = "arhm-server-4";
            String password = "cc1052407351";
            String command = "cd testJava/topologyRingWithSockets/; cat serverData.txt";

	    ConexionSSH conexion = new ConexionSSH(host, user, password, command);
	   String[] aux = new String[200];
	    aux = conexion.getMessages();
	   int size = aux.length;
		for (int i=0; i < size; i++){
            if(aux[i] != null){
            System.out.println(aux[i]);                
            }
		}
       }
    }
