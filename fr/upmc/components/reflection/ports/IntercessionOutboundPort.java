package fr.upmc.components.reflection.ports;

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

import java.io.PrintStream;
import fr.upmc.components.ComponentI;
import fr.upmc.components.PluginI;
import fr.upmc.components.ports.AbstractOutboundPort;
import fr.upmc.components.reflection.interfaces.IntercessionI;

//-----------------------------------------------------------------------------
/**
 * The class <code>IntercessionOutboundPort</code> defines the outbound port
 * associated the interface <code>IntercessionI</code>.
 *
 * <p><strong>Description</strong></p>
 * 
 * <p><strong>Invariant</strong></p>
 * 
 * <pre>
 * invariant		true
 * </pre>
 * 
 * <p>Created on : 2018-02-16</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public class				IntercessionOutboundPort
extends		AbstractOutboundPort
implements	IntercessionI
{
	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	public				IntercessionOutboundPort(
		String uri,
		ComponentI owner
		) throws Exception
	{
		super(uri, IntercessionI.class, owner) ;
	}

	public				IntercessionOutboundPort(
		ComponentI owner
		) throws Exception
	{
		super(IntercessionI.class, owner) ;
	}


	// ------------------------------------------------------------------------
	// Plug-ins facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#installPlugin(fr.upmc.components.PluginI)
	 */
	@Override
	public void			installPlugin(PluginI plugin) throws Exception
	{
		((IntercessionI)this.connector).installPlugin(plugin) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#uninstallPlugin(java.lang.String)
	 */
	@Override
	public void			uninstallPlugin(String pluginId) throws Exception
	{
		((IntercessionI)this.connector).uninstallPlugin(pluginId) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#initialisePlugin(java.lang.String)
	 */
	@Override
	public void			initialisePlugin(String pluginURI) throws Exception
	{
		((IntercessionI)this.connector).initialisePlugin(pluginURI) ;
	}

	// ------------------------------------------------------------------------
	// Logging facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#toggleLogging()
	 */
	@Override
	public void			toggleLogging() throws Exception
	{
		((IntercessionI)this.connector).toggleLogging() ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#toggleTracing()
	 */
	@Override
	public void			toggleTracing() throws Exception
	{
		((IntercessionI)this.connector).toggleTracing() ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#logMessage(java.lang.String)
	 */
	@Override
	public void			logMessage(String message) throws Exception
	{
		((IntercessionI)this.connector).logMessage(message) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLog()
	 */
	@Override
	public void			printExecutionLog() throws Exception
	{
		((IntercessionI)this.connector).printExecutionLog() ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLog(java.io.PrintStream)
	 */
	@Override
	public void			printExecutionLog(PrintStream out) throws Exception
	{
		((IntercessionI)this.connector).printExecutionLog(out) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLogOnFile(java.lang.String)
	 */
	@Override
	public void			printExecutionLogOnFile(String fileName)
	throws Exception
	{
		((IntercessionI)this.connector).printExecutionLogOnFile(fileName) ;
	}

	// ------------------------------------------------------------------------
	// Implemented interfaces management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#addRequiredInterface(java.lang.Class)
	 */
	@Override
	public void			addRequiredInterface(Class<?> inter)
	throws Exception
	{
		((IntercessionI)this.connector).addRequiredInterface(inter) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#removeRequiredInterface(java.lang.Class)
	 */
	@Override
	public void			removeRequiredInterface(Class<?> inter)
	throws Exception
	{
		((IntercessionI)this.connector).removeRequiredInterface(inter) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#addOfferedInterface(java.lang.Class)
	 */
	@Override
	public void			addOfferedInterface(Class<?> inter) throws Exception
	{
		((IntercessionI)this.connector).addOfferedInterface(inter) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#removeOfferedInterface(java.lang.Class)
	 */
	@Override
	public void			removeOfferedInterface(Class<?> inter)
	throws Exception
	{
		((IntercessionI)this.connector).removeOfferedInterface(inter) ;
	}

	// ------------------------------------------------------------------------
	// Port management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortConnection(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void			doPortConnection(
		String portURI,
		String otherPortURI,
		String ccname
		) throws Exception
	{
		((IntercessionI)this.connector).
							doPortConnection(portURI, otherPortURI, ccname) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortDisconnection(java.lang.String)
	 */
	@Override
	public void			doPortDisconnection(String portURI)
	throws Exception
	{
		((IntercessionI)this.connector).doPortDisconnection(portURI) ;
	}

	// ------------------------------------------------------------------------
	// Reflection facility
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#insertBeforeDeclaredMethod(java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public void			insertBeforeDeclaredMethod(
		String methodName,
		String[] parametersCanonicalClassNames,
		String code
		) throws Exception
	{
		((IntercessionI)this.connector).
			insertBeforeDeclaredMethod(
					methodName, parametersCanonicalClassNames, code) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#insertAfterDeclaredMethod(java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public void			insertAfterDeclaredMethod(
		String methodName,
		String[] parametersCanonicalClassNames,
		String code
		) throws Exception
	{
		((IntercessionI)this.connector).
			insertAfterDeclaredMethod(
					methodName, parametersCanonicalClassNames, code) ;
	}
}
//-----------------------------------------------------------------------------
