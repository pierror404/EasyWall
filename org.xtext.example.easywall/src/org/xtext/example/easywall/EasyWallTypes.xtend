package org.xtext.example.easywall

import org.xtext.example.easywall.easyWall.EFType

class EasyWallTypes {
	public static val MAP = #{
        EFType.INT -> "long",
        EFType.STRING -> "String",
        EFType.BOOL -> "boolean",
        EFType.NETWORK -> "Network",
        EFType.IPV4 -> "IPv4",
        EFType.IPV6 -> "IPv6",
        EFType.PORT -> "NetPort",
        EFType.PROTOCOL -> "IProtocol",
        EFType.DIRECTION -> "Direction"
    }
}