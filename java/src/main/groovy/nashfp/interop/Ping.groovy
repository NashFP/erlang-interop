package nashfp.interop

import com.ericsson.otp.erlang.*

class Ping {

    static main(args) {
    
        // handle args
        List argsl = args.toList()
        String rnode = argsl[0] //requred
        String lnode = argsl[1] ?: 'mouse'
        String trace = argsl[2] ?: '0'

        // Log command line arguments
        println 'Arguments:'
        println "\tremote node: $rnode"
        println "\tlocal node: $lnode"
        println "\ttrace: $trace"

        // Enable jinterface tracing, 0 -> 4, 4 is most verbose
        System.properties['OtpConnection.trace'] = trace

        // Create an erlang node
        OtpNode cnode = new OtpNode(lnode)
        println "Created Java Node: $cnode"

        // Ping cat node
        // This only seems to work if the remote node is created using erl -name cat
        // I could never get this to work using -sname
        // Also, the -daemon flag does not appear to be necessary
        println "Pinging remote node: $rnode"
        println cnode.ping(rnode, 10000) ? 'pong' : 'pang'

	}

}
