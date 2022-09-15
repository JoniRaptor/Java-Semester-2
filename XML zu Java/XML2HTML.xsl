<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    td.schueler {
                        background-color: red;
                    }
                </style>
            </head>
            <body>
                <table>
                    <tr>
                        <th>Jahrgang</th>
                        <th>Name</th>
                        <th>Nummer</th>
                    </tr>
                    <xsl:for-each select="schuelerListe/Schueler">
                        <tr>
                            <td>
                                <xsl:value-of select="jahrgang"/>
                            </td>
                            <td class="schueler">
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="nummer"/>
                            </td>
                        </tr>
                    </xsl:for-each> 
                </table>  
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>