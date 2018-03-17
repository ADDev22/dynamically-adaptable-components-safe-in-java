package fr.upmc.components.examples.reflection;

import fr.upmc.components.cvm.AbstractCVM ;
import fr.upmc.components.examples.reflection.components.ReflectionClient;
import fr.upmc.components.examples.reflection.components.ReflectionServer;

// -----------------------------------------------------------------------------
/**
 * The class <code>CVM</code> assembles the component and start the execution
 * of the reflection example as a mono-JVM application.
 *
 * <p><strong>Description</strong></p>
 * 
 * To be able to compile and execute this example, the jar
 * <code>tools.jar</code> both in the classpath of the compiler and in
 * the classpath of the VM. The VM must also be passed as argument
 * the java agent <code>hotswap.jar</code>, provided in the example
 * directory.
 * 
 * The jar of the tool javassist (<code>javassist.jar</code>, typically)
 * must also be in the classpath.
 * 
 * <p><strong>Invariant</strong></p>
 * 
 * <pre>
 * invariant		true
 * </pre>
 * 
 * <p>Created on : 2016-02-25</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public class			CVM
extends		AbstractCVM
{
	protected static String		SERVER_RIP_URI = "server-rip" ;

	public				CVM() throws Exception
	{
		super() ;
	}

	/**
	 * @see fr.upmc.components.cvm.AbstractCVM#deploy()
	 */
	@Override
	public void			deploy() throws Exception
	{
		ReflectionServer server = new ReflectionServer(SERVER_RIP_URI) ;
		this.addDeployedComponent(server) ;

		ReflectionClient client = new ReflectionClient(SERVER_RIP_URI) ;
		this.addDeployedComponent(client) ;

		super.deploy();
	}

	public static void	main(String[] args)
	{
		try {
			CVM c = new CVM() ;
			c.deploy() ;
			System.out.println("starting...") ;
			c.start() ;
			c.execute() ;
			Thread.sleep(1000L) ;
			System.out.println("shutting down...") ;
			System.out.print("\007"); System.out.flush();
			c.shutdown() ;
			System.out.println("ending...") ;
			System.exit(0) ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
//-----------------------------------------------------------------------------
