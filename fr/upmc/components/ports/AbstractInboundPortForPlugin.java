package fr.upmc.components.ports;

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

//----------------------------------------------------------------------------
/**
 * The class <code>AbstractInboundPortForPlugin</code> extends the standard
 * inbound port for the case where the services to be called is implemented
 * by a plug-in.
 *
 * <p><strong>Description</strong></p>
 * 
 * The inbound port must directly call a plug-in with a specific URI, so
 * the plug-in URI is passed at the creation of the port and used at each
 * call.
 * 
 * <p><strong>Invariant</strong></p>
 * 
 * <pre>
 * invariant		true
 * </pre>
 * 
 * <p>Created on : 2017-12-22</p>
 * 
 * @author	<a href="mailto:Jacques.Malenfant@lip6.fr">Jacques Malenfant</a>
 * @version	$Name$ -- $Revision$ -- $Date$
 */
public abstract class	AbstractInboundPortForPlugin
extends		AbstractInboundPort
{
	// ------------------------------------------------------------------------
	// Port instance variables and constructors
	// ------------------------------------------------------------------------

	private static final long	serialVersionUID = 1L ;
	protected final String		pluginURI ;

	/**
	 * create and initialise inbound ports, with a given URI and a given
	 * plug-in URI.
	 * 
	 * <p><strong>Contract</strong></p>
	 * 
	 * <pre>
	 * pre	uri != null and owner != null
	 * pre	OfferedI.class.isAssignableFrom(implementedInterface)
	 * pre	pluginURI != null and owner.isInstalled(pluginURI) ;
	 * post	this.getImplementedInterface().equals(implementedInterface)
	 * post	this.getOwner().equals(owner)
	 * post	this.getPortURI().equals(uri)
	 * </pre>
	 *
	 * @param uri					unique identifier of the port.
	 * @param implementedInterface	interface implemented by this port.
	 * @param pluginURI				URI of the plug-in to be called.
	 * @param owner					component that owns this port.
	 * @throws Exception
	 */
	public				AbstractInboundPortForPlugin(
		String uri,
		Class<?> implementedInterface,
		String pluginURI,
		ComponentI owner
		) throws Exception
	{
		super(uri, implementedInterface, owner);

		assert	pluginURI != null ;
		assert	owner.isInstalled(pluginURI) ;

		this.pluginURI = pluginURI ;
	}

	/**
	 * create and initialise inbound ports with an automatically generated URI
	 * but a given plug-in URI.
	 * 
	 * <p><strong>Contract</strong></p>
	 * 
	 * <pre>
	 * pre	owner != null
	 * pre	OfferedI.class.isAssignableFrom(implementedInterface)
	 * pre	owner.isInstalled(pluginURI) ;
	 * post	this.getImplementedInterface().equals(implementedInterface)
	 * post	this.getOwner().equals(owner)
	 * post	this.getPortURI().equals(uri)
	 * </pre>
	 *
	 * @param implementedInterface	interface implemented by this port.
	 * @param pluginURI				URI of the plug-in to be called.
	 * @param owner					component that owns this port.
	 * @throws Exception
	 */
	public				AbstractInboundPortForPlugin(
		Class<?> implementedInterface,
		String pluginURI,
		ComponentI owner
		) throws Exception
	{
		super(implementedInterface, owner);

		assert	pluginURI != null ;

		this.pluginURI = pluginURI ;
	}

	// ------------------------------------------------------------------------
	// Port methods
	// ------------------------------------------------------------------------

	/**
	 * @see fr.upmc.components.ports.AbstractInboundPort#getServiceProviderReference()
	 */
	@Override
	public Object		getServiceProviderReference() throws Exception
	{
		return this.owner.getPlugin(this.pluginURI) ;
	}
}
//----------------------------------------------------------------------------
