package test;

import java.io.InputStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
  import com.jcraft.jsch.Session;

import logic.*;

    public class SSHCommandExecutor {
        /** * @param args */
        public static void main(String[] args) {
            String host = "192.168.0.21";
            String user = "arhm-server-4";
            String password = "cc1052407351";
            String command = "cd testJava/topologyRingWithSockets/; sh compile.sh";

	    ConexionSSH conexion = new ConexionSSH(host, user, password, command); String host = "192.168.0.21";
            String user = "arhm-server-4";
            String password = "cc1052407351";
            String command = "cd testJava/topologyRingWithSockets/; sh$


	   

        }
    }
