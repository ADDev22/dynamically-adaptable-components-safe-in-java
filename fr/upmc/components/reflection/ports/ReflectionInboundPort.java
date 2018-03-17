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
import fr.upmc.components.ComponentStateI;
import fr.upmc.components.PluginI;
import fr.upmc.components.ports.AbstractInboundPort;
import fr.upmc.components.reflection.interfaces.ReflectionI;

//-----------------------------------------------------------------------------
/**
 * The class <code>ReflectionInboundPort</code> defines the inbound port
 * associated the interface <code>ReflectionI</code>.
 *
 * <p><strong>Description</strong></p>
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
public class				ReflectionInboundPort
extends		AbstractInboundPort
implements	ReflectionI
{
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	public				ReflectionInboundPort(
		String uri,
		ComponentI owner
		) throws Exception
	{
		super(uri, ReflectionI.class, owner) ;
	}

	public				ReflectionInboundPort(
		ComponentI owner
		) throws Exception
	{
		super(ReflectionI.class, owner);
	}

	// ------------------------------------------------------------------------
	// Plug-ins facilities
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#installPlugin(fr.upmc.components.PluginI)
	 */
	@Override
	public void			installPlugin(final PluginI plugin) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.installPlugin(plugin) ;
							return null ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#hasInstalledPlugins()
	 */
	@Override
	public boolean		hasInstalledPlugins() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.hasInstalledPlugins() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#uninstallPlugin(java.lang.String)
	 */
	@Override
	public void			uninstallPlugin(final String pluginId) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.uninstallPlugin(pluginId) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isInstalled(java.lang.String)
	 */
	@Override
	public boolean		isInstalled(final String pluginId) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isInstalled(pluginId) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getPlugin(java.lang.String)
	 */
	@Override
	public PluginI		getPlugin(final String pluginURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<PluginI>() {
						@Override
						public PluginI call() throws Exception {
							return comp.getPlugin(pluginURI) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#initialisePlugin(java.lang.String)
	 */
	@Override
	public void			initialisePlugin(final String pluginURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.initialisePlugin(pluginURI) ;
							return null ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isInitialised(java.lang.String)
	 */
	@Override
	public boolean		isInitialised(final String pluginURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isInitialised(pluginURI) ;
						}
					}) ;
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
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.toggleLogging() ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#toggleTracing()
	 */
	@Override
	public void			toggleTracing() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.toggleTracing() ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#logMessage(java.lang.String)
	 */
	@Override
	public void			logMessage(final String message) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.logMessage(message) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isLogging()
	 */
	@Override
	public boolean		isLogging() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isLogging() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isTracing()
	 */
	@Override
	public boolean		isTracing() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isTracing() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLog()
	 */
	@Override
	public void			printExecutionLog() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.printExecutionLog() ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLog(java.io.PrintStream)
	 */
	@Override
	public void			printExecutionLog(final PrintStream out) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.printExecutionLog(out) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#printExecutionLogOnFile(java.lang.String)
	 */
	@Override
	public void			printExecutionLogOnFile(final String fileName)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.printExecutionLogOnFile(fileName) ;
							return null;
						}
					}) ;
	}

	// ------------------------------------------------------------------------
	// Internal behaviour requests
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isInStateAmong(fr.upmc.components.ComponentStateI[])
	 */
	@Override
	public boolean		isInStateAmong(final ComponentStateI[] states)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isInStateAmong(states) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#notInStateAmong(fr.upmc.components.ComponentStateI[])
	 */
	@Override
	public boolean		notInStateAmong(final ComponentStateI[] states)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.notInStateAmong(states) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isConcurrent()
	 */
	@Override
	public boolean		isConcurrent() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isConcurrent() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#canScheduleTasks()
	 */
	@Override
	public boolean		canScheduleTasks() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.canScheduleTasks() ;
						}
					}) ;
	}

	// ------------------------------------------------------------------------
	// Implemented interfaces management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getInterfaces()
	 */
	@Override
	public Class<?>[]	getInterfaces() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Class<?>[]>() {
						@Override
						public Class<?>[] call() throws Exception {
							return comp.getInterfaces() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getInterface(java.lang.Class)
	 */
	@Override
	public Class<?>		getInterface(final Class<?> inter) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
				new ComponentI.ComponentService<Class<?>>() {
					@Override
					public Class<?> call() throws Exception {
						return comp.getInterface(inter) ;
					}
				}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getRequiredInterfaces()
	 */
	@Override
	public Class<?>[]	getRequiredInterfaces() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Class<?>[]>() {
						@Override
						public Class<?>[] call() throws Exception {
							return comp.getRequiredInterfaces() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getRequiredInterface(java.lang.Class)
	 */
	@Override
	public Class<?>		getRequiredInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
				new ComponentI.ComponentService<Class<?>>() {
					@Override
					public Class<?> call() throws Exception {
						return comp.getRequiredInterface(inter) ;
					}
				}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getOfferedInterfaces()
	 */
	@Override
	public Class<?>[]	getOfferedInterfaces() throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Class<?>[]>() {
						@Override
						public Class<?>[] call() throws Exception {
							return comp.getOfferedInterfaces() ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getOfferedInterface(java.lang.Class)
	 */
	@Override
	public Class<?>		getOfferedInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
				new ComponentI.ComponentService<Class<?>>() {
					@Override
					public Class<?> call() throws Exception {
						return comp.getOfferedInterface(inter) ;
					}
				}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#addRequiredInterface(java.lang.Class)
	 */
	@Override
	public void			addRequiredInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.addRequiredInterface(inter) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#removeRequiredInterface(java.lang.Class)
	 */
	@Override
	public void			removeRequiredInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.removeRequiredInterface(inter) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#addOfferedInterface(java.lang.Class)
	 */
	@Override
	public void			addOfferedInterface(final Class<?> inter) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.addOfferedInterface(inter) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#removeOfferedInterface(java.lang.Class)
	 */
	@Override
	public void			removeOfferedInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		this.owner.handleRequestSync(
					new ComponentI.ComponentService<Void>() {
						@Override
						public Void call() throws Exception {
							comp.removeOfferedInterface(inter) ;
							return null;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isInterface(java.lang.Class)
	 */
	@Override
	public boolean		isInterface(final Class<?> inter) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isInterface(inter) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isRequiredInterface(java.lang.Class)
	 */
	@Override
	public boolean		isRequiredInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isRequiredInterface(inter) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isOfferedInterface(java.lang.Class)
	 */
	@Override
	public boolean		isOfferedInterface(final Class<?> inter) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isOfferedInterface(inter) ;
						}
					}) ;
	}

	// ------------------------------------------------------------------------
	// Port management
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#findPortURIsFromInterface(java.lang.Class)
	 */
	@Override
	public String[]		findPortURIsFromInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<String[]>() {
						@Override
						public String[] call() throws Exception {
							return comp.findPortURIsFromInterface(inter) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#findInboundPortURIsFromInterface(java.lang.Class)
	 */
	@Override
	public String[]		findInboundPortURIsFromInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<String[]>() {
						@Override
						public String[] call() throws Exception {
							return comp.findInboundPortURIsFromInterface(inter) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#findOutboundPortURIsFromInterface(java.lang.Class)
	 */
	@Override
	public String[]		findOutboundPortURIsFromInterface(final Class<?> inter)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<String[]>() {
						@Override
						public String[] call() throws Exception {
							return comp.findOutboundPortURIsFromInterface(inter) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#getPortImplementedInterface(java.lang.String)
	 */
	@Override
	public Class<?>		getPortImplementedInterface(final String portURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Class<?>>() {
						@Override
						public Class<?> call() throws Exception {
							return comp.getPortImplementedInterface(portURI) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntrospectionI#isPortConnected(java.lang.String)
	 */
	@Override
	public boolean		isPortConnected(final String portURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		return this.owner.handleRequestSync(
					new ComponentI.ComponentService<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return comp.isPortConnected(portURI) ;
						}
					}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortConnection(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void			doPortConnection(
		final String portURI,
		final String otherPortURI,
		final String ccname
		) throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		comp.handleRequestSync(
				new ComponentI.ComponentService<Void>() {
					@Override
					public Void call() throws Exception {
						comp.doPortConnection(portURI, otherPortURI, ccname) ;
						return null ;
					}
				}) ;
	}

	/**
	 * @see fr.upmc.components.reflection.interfaces.IntercessionI#doPortDisconnection(java.lang.String)
	 */
	@Override
	public void			doPortDisconnection(final String portURI)
	throws Exception
	{
		final ComponentI comp = (ComponentI) this.getServiceProviderReference() ;
		comp.handleRequestSync(
				new ComponentI.ComponentService<Void>() {
					@Override
					public Void call() throws Exception {
						comp.doPortDisconnection(portURI) ;
						return null ;
					}
				}) ;
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
		final ComponentI comp =
							(ComponentI) this.getServiceProviderReference() ;
		comp.handleRequestSync(
				new ComponentI.ComponentService<Void>() {
					@Override
					public Void call() throws Exception {
						comp.insertBeforeDeclaredMethod(
							methodName, parametersCanonicalClassNames, code) ;
						return null ;
					}
				}) ;
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
		final ComponentI comp =
				(ComponentI) this.getServiceProviderReference() ;
		comp.handleRequestSync(
				new ComponentI.ComponentService<Void>() {
					@Override
					public Void call() throws Exception {
						comp.insertAfterDeclaredMethod(
							methodName, parametersCanonicalClassNames, code) ;
						return null ;
					}
				}) ;
	}
}
//-----------------------------------------------------------------------------