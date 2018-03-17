package fr.upmc.components.examples.ddeployment_cs;

//Copyright Jacques Malenfant, Univ. Pierre et Marie Curie.
//
//Jacques.Malenfant@lip6.fr
//
//This software is a computer program whose purpose is to provide a
//basic component programming model to program with components
//distributed applications in the Java programming language.
//
//This software is governed by the CeCILL-C license under French law and
//abiding by the rules of distribution of free software.  You can use,
//modify and/ or redistribute the software under the terms of the
//CeCILL-C license as circulated by CEA, CNRS and INRIA at the following
//URL "http://www.cecill.info".
//
//As a counterpart to the access to the source code and  rights to copy,
//modify and redistribute granted by the license, users are provided only
//with a limited warranty  and the software's author,  the holder of the
//economic rights,  and the successive licensors  have only  limited
//liability. 
//
//In this respect, the user's attention is drawn to the risks associated
//with loading,  using,  modifying and/or developing or reproducing the
//software by the user in light of its specific status of free software,
//that may mean  that it is complicated to manipulate,  and  that  also
//therefore means  that it is reserved for developers  and  experienced
//professionals having in-depth computer knowledge. Users are therefore
//encouraged to load and test the software's suitability as regards their
//requirements in conditions enabling the security of their systems and/or 
//data to be ensured and,  more generally, to use and operate it in the 
//same conditions as regards security. 
//
//The fact that you are presently reading this means that you have had
//knowledge of the CeCILL-C license and that you accept its terms.

import fr.upmc.components.ComponentI;
import fr.upmc.components.cvm.AbstractDistributedCVM;
import fr.upmc.components.examples.ddeployment_cs.components.DynamicAssembler;

//-----------------------------------------------------------------------------
/**
 * The class <code>DistributedCVM</code> creates a component assembly for the
 * multiple-JVM execution of the dynamic deployment example.
 *
 * <p><strong>Description</strong></p>
 * 
 * <p><strong>Invariant</strong></p>
 * 
 * <pre>
 * invariant		true
 * </pre>
 * 
 * <p>Created on : 2014-03-14</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public class				DistributedCVM
extends		AbstractDistributedCVM
{
	/* The following must be the same as the ones in the confi.xml file.	*/
	protected static String		ASSEMBLER_JVM_URI = "assembler" ;
	protected static String		PROVIDER_JVM_URI = "provider" ;
	protected static String		CONSUMER_JVM_URI = "consumer" ;

	protected static String		Consumer_OUTBOUND_PORT_URI = "oport" ;
	protected static String		Provider_INBOUND_PORT_URI = "iport" ;

	protected DynamicAssembler	da ;

	public				DistributedCVM(
		String[] args
		) throws Exception
	{
		super(args);
	}

	/**
	 * 
	 * <p><strong>Contract</strong></p>
	 * 
	 * <pre>
	 * pre	true				// no more preconditions.
	 * post	true				// no more postconditions.
	 * </pre>
	 * 
	 * @see fr.upmc.components.cvm.AbstractDistributedCVM#instantiateAndPublish()
	 */
	@Override
	public void			instantiateAndPublish() throws Exception
	{
		if (thisJVMURI.equals(ASSEMBLER_JVM_URI)) {

			this.da = new DynamicAssembler(CONSUMER_JVM_URI,
										  PROVIDER_JVM_URI,
										  Consumer_OUTBOUND_PORT_URI,
										  Provider_INBOUND_PORT_URI) ;
			this.addDeployedComponent(this.da) ;

		}

		super.instantiateAndPublish();
	}

	/**
	 * @see fr.upmc.components.cvm.AbstractDistributedCVM#start()
	 */
	@Override
	public void			start() throws Exception
	{
		super.start() ;

		if (thisJVMURI.equals(ASSEMBLER_JVM_URI)) {
			final DynamicAssembler fDa = this.da ;
			this.da.runTask(
				new ComponentI.ComponentTask() {
						@Override
						public void run() {
							try {
								fDa.dynamicDeploy() ;
							} catch (Exception e) {
								throw new RuntimeException(e) ;
							}
						}
					}) ;
		}
	}

	/**
	 * @see fr.upmc.components.cvm.AbstractDistributedCVM#execute()
	 */
	@Override
	public void			execute() throws Exception
	{
		super.execute();

		if (thisJVMURI.equals(ASSEMBLER_JVM_URI)) {
			final DynamicAssembler fDa = this.da ;
			this.da.runTask(
				new ComponentI.ComponentTask() {
						@Override
						public void run() {
							try {
								fDa.launch() ;
							} catch (Exception e) {
								throw new RuntimeException(e) ;
							}
						}
					}) ;
		}
	}

	public static void	main(String[] args)
	{
		System.out.println("Beginning") ;
		try {
			DistributedCVM dda = new DistributedCVM(args) ;
			System.out.println("Deploying") ;
			dda.deploy() ;
			System.out.println("Starting") ;
			dda.start() ;
			System.out.println("Executing") ;
			dda.execute() ;
			Thread.sleep(15000) ;
			dda.shutdown() ;
		} catch (Exception e) {
			throw new RuntimeException(e) ;
		}
		System.out.println("Main thread ending") ;
		System.exit(0);
	}
}
//-----------------------------------------------------------------------------
