
Aurelien Ribon's CSS Engine for Swing
-------------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/css-engine-swing](http://artifacts.griffon-framework.org/plugin/css-engine-swing)


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

The plugin will automatically init the CSS engine at startup, in other words, you don't have to make the following calls in your code

        SwingStyle.init()
        AruiStyle.init()

You must however apply Styles to any components, like this

        Style style = new Style(myCssFileUrl)
        Style.apply(myRootComponent, style)

[1]: http://code.google.com/p/java-universal-css-engine/

