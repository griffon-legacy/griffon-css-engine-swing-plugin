/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package griffon.plugins.aurelienribon.factory

import groovy.swing.factory.ComponentFactory
import java.awt.image.BufferedImage
import aurelienribon.ui.components.ImagePanel

/**
 * @author Andres Almiray
 */
class ImagePanelFactory extends ComponentFactory {
    ImagePanelFactory() {
        super(ImagePanel)
    }
    
    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        if (value == null) {
            if (attributes.containsKey("image")) {
                value = attributes.remove("image")
                if (!(value instanceof BufferedImage)) {
                    throw new RuntimeException("In $name image: attributes must be of type java.awt.image.BufferedImage")
                }
            } else if (attributes.containsKey("url")) {
                value = attributes.remove("url")
                if (!(value instanceof URL)) {
                    throw new RuntimeException("In $name url: attributes must be of type java.net.URL")
                }
            } else if (attributes.containsKey("file")) {
                value = attributes.remove("file")
                if (value instanceof GString) value = value as String
                if (value instanceof File) {
                    value = value.toURL()
                } else if (!(value instanceof String)) {
                    throw new RuntimeException("In $name file: attributes must be of type java.io.File or a string")
                }
            }
        } else if (value instanceof GString) {
            value = value as String
        }

        // not else if so we can adjust for the case of file string where the file does not exist
        def resource = null
        if ((value == null) && (attributes.containsKey("resource"))) {
            resource = attributes.remove('resource')
        } else if ((value instanceof String)) {
            if(new File(value).exists()) {
                value = new File(value)
            } else {
                resource = value
            }
        }
        
        if (resource != null) {
            def klass = builder.context.owner
            def origValue = value
            if (attributes.containsKey("class")) {
                klass = attributes.remove("class")
            }
            if (klass == null) {
                klass = ImagePanelFactory
            } else if (!(klass instanceof Class)) {
                klass = klass.class
            }
            // for now try URL approach.
            // we may need to extract the byte[] for some packaging cases
            value = klass.getResource(resource)
            if (value == null) {
                throw new RuntimeException("In $name the value argument '$origValue' does not refer to a file or a class resource")
            }
        }

        if (value == null) {
            throw new RuntimeException("$name has neither a value argument or one of image:, url:, file:, or resource:")
        }
        
        ImagePanel panel = super.newInstance(builder, name, value, attributes)
        if(attributes.containsKey('regionX') && 
           attributes.containsKey('regionY') &&
           attributes.containsKey('regionW') && 
           attributes.containsKey('regionH') &&
           (value instanceof URL || value instanceof File)){
            panel.setImage(value, 
                attributes.containsKey('regionX') as int ,
                attributes.containsKey('regionY') as int,
                attributes.containsKey('regionW') as int,
                attributes.containsKey('regionH') as int)
        } else {
            panel.setImage(value)
        }
    }
}