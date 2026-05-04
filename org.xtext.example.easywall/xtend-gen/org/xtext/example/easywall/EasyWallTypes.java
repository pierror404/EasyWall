package org.xtext.example.easywall;

import java.util.Collections;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.xtext.example.easywall.easyWall.EFType;

@SuppressWarnings("all")
public class EasyWallTypes {
  public static final Map<EFType, String> MAP = Collections.<EFType, String>unmodifiableMap(CollectionLiterals.<EFType, String>newHashMap(Pair.<EFType, String>of(EFType.INT, "long"), Pair.<EFType, String>of(EFType.STRING, "String"), Pair.<EFType, String>of(EFType.BOOL, "boolean"), Pair.<EFType, String>of(EFType.NETWORK, "Network"), Pair.<EFType, String>of(EFType.IPV4, "IPv4"), Pair.<EFType, String>of(EFType.IPV6, "IPv6"), Pair.<EFType, String>of(EFType.PORT, "NetPort"), Pair.<EFType, String>of(EFType.PROTOCOL, "IProtocol"), Pair.<EFType, String>of(EFType.DIRECTION, "Direction")));
}
