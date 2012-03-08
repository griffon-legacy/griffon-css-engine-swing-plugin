/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class CssEngineSwingGriffonPlugin {
    // the plugin version
    String version = '0.1'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-css-engine-swing-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = "Aurelien Ribon's CSS Engine for Swing"
    String description = '''
Inetgrates with Aurelien Ribon's [Universal CSS Engine][1] for swing in Griffon applications.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*            | *Type*                                         |
| ----------------- | ---------------------------------------------- |
| richButton        | `aurelienribon.ui.components.Button`           |
| groupBorder       | `aurelienribon.ui.components.GroupBorder`      |
| imagePanel        | `aurelienribon.ui.components.ImagePanel`       |
| tabPanel          | `aurelienribon.ui.components.TabPanel`         |
| tabPanelModel     | `aurelienribon.ui.components.TabPanelModel`    |
| transparentPanel  | `aurelienribon.ui.components.TransparentPanel` |

The `imagePanel` node supports the following properties

 * **image** - points to a `java.awt.image.BufferedImage` instance
 * **url** - URL of an image resource
 * **file** - image file that can be loaded by the application
 * **resource** - name of an image resource available in the classpath
 * **class** - the class used to load the resource
 * **regionX** - x anchor
 * **regionY** - y anchor
 * **regionW** - w anchor
 * **regionH** - h anchor

[1]: http://code.google.com/p/java-universal-css-engine/
'''
}
