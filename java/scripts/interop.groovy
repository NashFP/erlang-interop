//@Grab(group='org.erlang.otp', module='jinterface', version='1.5.6')
import com.ericsson.otp.erlang.*

// Remote node name, change this to ping a different node
String rnode = 'cat@alfa.local'

// Enable jinterface tracing, 0 -> 4, 4 is most verbose
System.properties['OtpConnection.trace'] = '4'

// Create an erlang node
// To keep the same node between console runs we'll store the node in a binding variable
OtpNode cnode = (binding.variables.node) ?: (binding.variables.node = new OtpNode("mouse"))
println "Current Node: $cnode"

// Ping cat node
// This only seems to work if the remote node is created using erl -name hostname
// I could never get this to work using -sname
// Also, the -daemon flag does not appear to be necessary
println cnode.ping(rnode, 10000) ? 'pong' : 'pang'