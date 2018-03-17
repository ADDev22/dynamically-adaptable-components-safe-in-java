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

import fr.upmc.components.ComponentStateI;
import fr.upmc.components.PluginI;
import fr.upmc.components.interfaces.OfferedI;
import fr.upmc.components.interfaces.RequiredI;

//-----------------------------------------------------------------------------
/**
 * The interface <code>IntrospectionI</code> defines the introspection
 * services offered by the Basic Component Model.
 *
 * <p><strong>Description</strong></p>
 * 
 * The Basic Component Model reflection facility is still under construction.
 * 
 * The interface <code>IntrospectionI</code> mirrors to a large extent
 * the interface <code>ComponentI</code> implemented by the abstract
 * class <code>AbstractComponent</code> and exposes the methods that
 * allow to consult the internal representation of the component.
 * 
 * <p>Created on : 2016-02-25</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public interface			IntrospectionI
extends		OfferedI,
			RequiredI
{
	// ------------------------------------------------------------------------
	// Plug-ins facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#hasInstalledPlugins()
	 */
	public boolean		hasInstalledPlugins() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isInstalled(java.lang.String)
	 */
	public boolean		isInstalled(String pluginURI) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getPlugin(java.lang.String)
	 */
	public PluginI		getPlugin(String pluginURI) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isInitialised(java.lang.String)
	 */
	public boolean		isInitialised(String pluginURI) throws Exception ;

	// ------------------------------------------------------------------------
	// Logging facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#isLogging()
	 */
	public boolean		isLogging() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isTracing()
	 */
	public boolean		isTracing() throws Exception ;

	// ------------------------------------------------------------------------
	// Internal behaviour requests
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#isInStateAmong(fr.upmc.components.ComponentStateI[])
	 */
	public boolean		isInStateAmong(ComponentStateI[] states)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#notInStateAmong(fr.upmc.components.ComponentStateI[])
	 */
	public boolean		notInStateAmong(ComponentStateI[] states)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isConcurrent()
	 */
	public boolean		isConcurrent() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#canScheduleTasks()
	 */
	public boolean		canScheduleTasks() throws Exception ;

	// ------------------------------------------------------------------------
	// Implemented interfaces management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#getInterfaces()
	 */
	public Class<?>[]	getInterfaces() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getInterface(java.lang.Class)
	 */
	public Class<?>		getInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getRequiredInterfaces()
	 */
	public Class<?>[]	getRequiredInterfaces() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getRequiredInterface(java.lang.Class)
	 */
	public Class<?>		getRequiredInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getOfferedInterfaces()
	 */
	public Class<?>[]	getOfferedInterfaces() throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getOfferedInterface(java.lang.Class)
	 */
	public Class<?>		getOfferedInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isInterface(java.lang.Class)
	 */
	public boolean		isInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isRequiredInterface(java.lang.Class)
	 */
	public boolean		isRequiredInterface(Class<?> inter) throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isOfferedInterface(java.lang.Class)
	 */
	public boolean		isOfferedInterface(Class<?> inter) throws Exception ;

	// ------------------------------------------------------------------------
	// Port management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ComponentI#findPortURIsFromInterface(java.lang.Class)
	 */
	public String[]		findPortURIsFromInterface(Class<?> inter)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#findInboundPortURIsFromInterface(java.lang.Class)
	 */
	public String[]		findInboundPortURIsFromInterface(Class<?> inter)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#findOutboundPortURIsFromInterface(java.lang.Class)
	 */
	public String[]		findOutboundPortURIsFromInterface(Class<?> inter)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#getPortImplementedInterface(java.lang.String)
	 */
	public Class<?>		getPortImplementedInterface(String portURI)
	throws Exception ;

	/**
	 * @see fr.upmc.components.ComponentI#isPortConnected(java.lang.String)
	 */
	public boolean		isPortConnected(String portURI)
	throws Exception ;

	// ------------------------------------------------------------------------
	// Reflection facility
	// ------------------------------------------------------------------------


}
//-----------------------------------------------------------------------------