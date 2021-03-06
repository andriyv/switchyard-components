/*
 * JBoss, Home of Professional Open Source Copyright 2009, Red Hat Middleware
 * LLC, and individual contributors by the @authors tag. See the copyright.txt
 * in the distribution for a full listing of individual contributors.
 * 
 * This is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA, or see the FSF
 * site: http://www.fsf.org.
 */
package org.switchyard.component.jca.config.model.v1;

import javax.xml.namespace.QName;

import org.switchyard.component.jca.JCAConstants;
import org.switchyard.component.jca.config.model.InteractionSpecModel;
import org.switchyard.component.jca.config.model.OperationModel;
import org.switchyard.config.Configuration;
import org.switchyard.config.model.BaseModel;
import org.switchyard.config.model.Descriptor;

/**
 * V1 Operation model.
 * 
 * @author <a href="mailto:tm.igarashi@gmail.com">Tomohisa Igarashi</a>
 *
 */
public class V1OperationModel extends BaseModel implements OperationModel {

    /**
     * Constructor.
     */
    public V1OperationModel() {
        super(new QName(JCAConstants.DEFAULT_NAMESPACE, JCAConstants.OPERATION));
        setModelChildrenOrder(JCAConstants.INTERACTION_SPEC);
    }
    
    /**
     * Constructor.
     * 
     * @param config configuration
     * @param desc descriptor
     */
    public V1OperationModel(Configuration config, Descriptor desc) {
        super(config, desc);
    }

    @Override
    public String getName() {
        return getModelAttribute(JCAConstants.NAME);
    }
    
    @Override
    public OperationModel setName(String name) {
        setModelAttribute(JCAConstants.NAME, name);
        return this;
    }
    
    @Override
    public InteractionSpecModel getInteractionSpec() {
        return (InteractionSpecModel) getFirstChildModel(JCAConstants.INTERACTION_SPEC);
    }

    @Override
    public OperationModel setInteractionSpec(InteractionSpecModel model) {
        setChildModel(model);
        return this;
    }

}
