package fr.upmc.components.reflection.interfaces;

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
import fr.upmc.components.PluginI;
import fr.upmc.components.interfaces.OfferedI;
import fr.upmc.components.interfaces.RequiredI;

//-----------------------------------------------------------------------------
/**
 * The interface <code>IntercessionI</code> defines the intercession
 * services offered by the Basic Component Model.
 *
 * <p><strong>Description</strong></p>
 * 
 * The Basic Component Model reflection facility is still under construction.
 * 
 * The interface <code>IntercessionI</code> mirrors to a large extent
 * the interface <code>ComponentI</code> implemented by the abstract
 * class <code>AbstractComponent</code> and exposes the methods that
 * allow to modify the internal representation of the component.
 * 
 * <p>Created on : 2016-02-25</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public interface			IntercessionI
extends		OfferedI,
			RequiredI
{
	// ------------------------------------------------------------------------
	// Plug-ins facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#installPlugin(fr.upmc.components.PluginI)
	 */
	public void			installPlugin(PluginI plugin) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#uninstallPlugin(java.lang.String)
	 */
	public void			uninstallPlugin(String pluginURI) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#initialisePlugin(java.lang.String)
	 */
	public void			initialisePlugin(String pluginURI) throws Exception ;

	// ------------------------------------------------------------------------
	// Logging facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#toggleLogging()
	 */
	public void			toggleLogging() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#toggleTracing()
	 */
	public void			toggleTracing() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#logMessage(java.lang.String)
	 */
	public void			logMessage(String message) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#printExecutionLog()
	 */
	public void			printExecutionLog() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#printExecutionLog(java.io.PrintStream)
	 */
	public void			printExecutionLog(PrintStream out) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#printExecutionLogOnFile(java.lang.String)
	 */
	public void			printExecutionLogOnFile(String fileName)
	throws	Exception ;

	// ------------------------------------------------------------------------
	// Implemented interfaces management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#addRequiredInterface(java.lang.Class)
	 */
	public void			addRequiredInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#removeRequiredInterface(java.lang.Class)
	 */
	public void			removeRequiredInterface(Class<?> inter)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#addOfferedInterface(java.lang.Class)
	 */
	public void			addOfferedInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#removeOfferedInterface(java.lang.Class)
	 */
	public void			removeOfferedInterface(Class<?> inter) throws Exception ;

	// ------------------------------------------------------------------------
	// Port management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortConnection(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void			doPortConnection(
		String portURI,
		String otherPortURI,
		String ccname
		) throws Exception ;

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortDisconnection(java.lang.String)
	 */
	public void			doPortDisconnection(
		String portURI
		) throws Exception ;

	// ------------------------------------------------------------------------
	// Reflection facility
	// ------------------------------------------------------------------------

	public void			insertBeforeDeclaredMethod(
		String methodName,
		String[] parametersCanonicalClassNames,
		String code
		) throws Exception ;

	public void			insertAfterDeclaredMethod(
		String methodName,
		String[] parametersCanonicalClassNames,
		String code
		) throws Exception ;
}
//-----------------------------------------------------------------------------
