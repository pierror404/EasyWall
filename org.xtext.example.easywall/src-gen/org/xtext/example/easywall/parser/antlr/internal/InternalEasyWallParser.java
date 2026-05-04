package org.xtext.example.easywall.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.easywall.services.EasyWallGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalEasyWallParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_EFIPV6SYNTAX", "RULE_EFIPV4SYNTAX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'pack'", "';'", "'import'", "'.'", "'.*'", "'firewall'", "'{'", "'}'", "'default'", "'apply'", "'set'", "'var'", "'='", "':'", "'fun'", "'('", "','", "')'", "'void'", "'return'", "'if'", "'else'", "'->'", "'true'", "'false'", "'any'", "'localhost'", "'this'", "'super'", "'new'", "'allow'", "'deny'", "'writelog'", "'getTime'", "'getPacketField'", "'rule'", "'at'", "'||'", "'or'", "'&&'", "'and'", "'!'", "'not'", "'=='", "'!='", "'isequalto'", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'div'", "'%'", "'/'", "'network'", "'netip'", "'netipv6'", "'netport'", "'protocol'", "'direction'", "'int'", "'string'", "'bool'", "'in'", "'out'", "'forward'", "'debug'", "'info'", "'warning'", "'error'", "'critical'", "'NetworkLayer'", "'TransportLayer'", "'ApplicationLayer'", "'IPv4'", "'IPv6'", "'ARP'", "'ICMP'", "'NAT'", "'RIP'", "'OSPF'", "'IPSEC'", "'IGMP'", "'UDP'", "'TCP'", "'QUIC'", "'SCTP'", "'HTTP'", "'HTTPS'", "'SMTP'", "'POP3'", "'IMAP'", "'FTP'", "'TFTP'", "'SNMP'", "'TELNET'", "'SSH'", "'DNS'", "'DHCP'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_EFIPV6SYNTAX=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int RULE_EFIPV4SYNTAX=8;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalEasyWallParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEasyWallParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEasyWallParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEasyWall.g"; }



     	private EasyWallGrammarAccess grammarAccess;

        public InternalEasyWallParser(TokenStream input, EasyWallGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "EFProgram";
       	}

       	@Override
       	protected EasyWallGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEFProgram"
    // InternalEasyWall.g:65:1: entryRuleEFProgram returns [EObject current=null] : iv_ruleEFProgram= ruleEFProgram EOF ;
    public final EObject entryRuleEFProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFProgram = null;


        try {
            // InternalEasyWall.g:65:50: (iv_ruleEFProgram= ruleEFProgram EOF )
            // InternalEasyWall.g:66:2: iv_ruleEFProgram= ruleEFProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFProgram=ruleEFProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFProgram"


    // $ANTLR start "ruleEFProgram"
    // InternalEasyWall.g:72:1: ruleEFProgram returns [EObject current=null] : ( ( (lv_header_0_0= ruleEFHeader ) ) ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) ) ) ;
    public final EObject ruleEFProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_header_0_0 = null;

        EObject lv_rules_1_0 = null;

        EObject lv_firewall_2_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:78:2: ( ( ( (lv_header_0_0= ruleEFHeader ) ) ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) ) ) )
            // InternalEasyWall.g:79:2: ( ( (lv_header_0_0= ruleEFHeader ) ) ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) ) )
            {
            // InternalEasyWall.g:79:2: ( ( (lv_header_0_0= ruleEFHeader ) ) ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) ) )
            // InternalEasyWall.g:80:3: ( (lv_header_0_0= ruleEFHeader ) ) ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) )
            {
            // InternalEasyWall.g:80:3: ( (lv_header_0_0= ruleEFHeader ) )
            // InternalEasyWall.g:81:4: (lv_header_0_0= ruleEFHeader )
            {
            // InternalEasyWall.g:81:4: (lv_header_0_0= ruleEFHeader )
            // InternalEasyWall.g:82:5: lv_header_0_0= ruleEFHeader
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFProgramAccess().getHeaderEFHeaderParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_header_0_0=ruleEFHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFProgramRule());
              					}
              					set(
              						current,
              						"header",
              						lv_header_0_0,
              						"org.xtext.example.easywall.EasyWall.EFHeader");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalEasyWall.g:99:3: ( ( (lv_rules_1_0= ruleEFRule ) )* | ( (lv_firewall_2_0= ruleEFFirewall ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EOF||LA2_0==48) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalEasyWall.g:100:4: ( (lv_rules_1_0= ruleEFRule ) )*
                    {
                    // InternalEasyWall.g:100:4: ( (lv_rules_1_0= ruleEFRule ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==48) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalEasyWall.g:101:5: (lv_rules_1_0= ruleEFRule )
                    	    {
                    	    // InternalEasyWall.g:101:5: (lv_rules_1_0= ruleEFRule )
                    	    // InternalEasyWall.g:102:6: lv_rules_1_0= ruleEFRule
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getEFProgramAccess().getRulesEFRuleParserRuleCall_1_0_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_4);
                    	    lv_rules_1_0=ruleEFRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getEFProgramRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"rules",
                    	      							lv_rules_1_0,
                    	      							"org.xtext.example.easywall.EasyWall.EFRule");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:120:4: ( (lv_firewall_2_0= ruleEFFirewall ) )
                    {
                    // InternalEasyWall.g:120:4: ( (lv_firewall_2_0= ruleEFFirewall ) )
                    // InternalEasyWall.g:121:5: (lv_firewall_2_0= ruleEFFirewall )
                    {
                    // InternalEasyWall.g:121:5: (lv_firewall_2_0= ruleEFFirewall )
                    // InternalEasyWall.g:122:6: lv_firewall_2_0= ruleEFFirewall
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFProgramAccess().getFirewallEFFirewallParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_firewall_2_0=ruleEFFirewall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFProgramRule());
                      						}
                      						set(
                      							current,
                      							"firewall",
                      							lv_firewall_2_0,
                      							"org.xtext.example.easywall.EasyWall.EFFirewall");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFProgram"


    // $ANTLR start "entryRuleEFHeader"
    // InternalEasyWall.g:144:1: entryRuleEFHeader returns [EObject current=null] : iv_ruleEFHeader= ruleEFHeader EOF ;
    public final EObject entryRuleEFHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFHeader = null;


        try {
            // InternalEasyWall.g:144:49: (iv_ruleEFHeader= ruleEFHeader EOF )
            // InternalEasyWall.g:145:2: iv_ruleEFHeader= ruleEFHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFHeaderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFHeader=ruleEFHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFHeader; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFHeader"


    // $ANTLR start "ruleEFHeader"
    // InternalEasyWall.g:151:1: ruleEFHeader returns [EObject current=null] : ( () (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )? ( (lv_imports_4_0= ruleEFImports ) )* ) ;
    public final EObject ruleEFHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_imports_4_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:157:2: ( ( () (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )? ( (lv_imports_4_0= ruleEFImports ) )* ) )
            // InternalEasyWall.g:158:2: ( () (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )? ( (lv_imports_4_0= ruleEFImports ) )* )
            {
            // InternalEasyWall.g:158:2: ( () (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )? ( (lv_imports_4_0= ruleEFImports ) )* )
            // InternalEasyWall.g:159:3: () (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )? ( (lv_imports_4_0= ruleEFImports ) )*
            {
            // InternalEasyWall.g:159:3: ()
            // InternalEasyWall.g:160:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEFHeaderAccess().getEFHeaderAction_0(),
              					current);
              			
            }

            }

            // InternalEasyWall.g:166:3: (otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalEasyWall.g:167:4: otherlv_1= 'pack' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ';'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEFHeaderAccess().getPackKeyword_1_0());
                      			
                    }
                    // InternalEasyWall.g:171:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalEasyWall.g:172:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalEasyWall.g:172:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalEasyWall.g:173:6: lv_name_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFHeaderAccess().getNameQualifiedNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFHeaderRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.xtext.example.easywall.EasyWall.QualifiedName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getEFHeaderAccess().getSemicolonKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalEasyWall.g:195:3: ( (lv_imports_4_0= ruleEFImports ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalEasyWall.g:196:4: (lv_imports_4_0= ruleEFImports )
            	    {
            	    // InternalEasyWall.g:196:4: (lv_imports_4_0= ruleEFImports )
            	    // InternalEasyWall.g:197:5: lv_imports_4_0= ruleEFImports
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEFHeaderAccess().getImportsEFImportsParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_imports_4_0=ruleEFImports();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEFHeaderRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_4_0,
            	      						"org.xtext.example.easywall.EasyWall.EFImports");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFHeader"


    // $ANTLR start "entryRuleEFImports"
    // InternalEasyWall.g:218:1: entryRuleEFImports returns [EObject current=null] : iv_ruleEFImports= ruleEFImports EOF ;
    public final EObject entryRuleEFImports() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFImports = null;


        try {
            // InternalEasyWall.g:218:50: (iv_ruleEFImports= ruleEFImports EOF )
            // InternalEasyWall.g:219:2: iv_ruleEFImports= ruleEFImports EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFImportsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFImports=ruleEFImports();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFImports; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFImports"


    // $ANTLR start "ruleEFImports"
    // InternalEasyWall.g:225:1: ruleEFImports returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' ) ;
    public final EObject ruleEFImports() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:231:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' ) )
            // InternalEasyWall.g:232:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' )
            {
            // InternalEasyWall.g:232:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' )
            // InternalEasyWall.g:233:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFImportsAccess().getImportKeyword_0());
              		
            }
            // InternalEasyWall.g:237:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // InternalEasyWall.g:238:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // InternalEasyWall.g:238:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // InternalEasyWall.g:239:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFImportsAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFImportsRule());
              					}
              					set(
              						current,
              						"importedNamespace",
              						lv_importedNamespace_1_0,
              						"org.xtext.example.easywall.EasyWall.QualifiedNameWithWildcard");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFImportsAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFImports"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalEasyWall.g:264:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalEasyWall.g:264:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalEasyWall.g:265:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalEasyWall.g:271:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalEasyWall.g:277:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalEasyWall.g:278:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalEasyWall.g:278:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalEasyWall.g:279:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalEasyWall.g:286:3: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalEasyWall.g:287:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalEasyWall.g:304:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalEasyWall.g:304:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalEasyWall.g:305:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalEasyWall.g:311:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:317:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalEasyWall.g:318:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalEasyWall.g:318:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalEasyWall.g:319:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_QualifiedName_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:329:3: (kw= '.*' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalEasyWall.g:330:4: kw= '.*'
                    {
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleEFFirewall"
    // InternalEasyWall.g:340:1: entryRuleEFFirewall returns [EObject current=null] : iv_ruleEFFirewall= ruleEFFirewall EOF ;
    public final EObject entryRuleEFFirewall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFFirewall = null;


        try {
            // InternalEasyWall.g:340:51: (iv_ruleEFFirewall= ruleEFFirewall EOF )
            // InternalEasyWall.g:341:2: iv_ruleEFFirewall= ruleEFFirewall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFFirewallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFFirewall=ruleEFFirewall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFFirewall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFFirewall"


    // $ANTLR start "ruleEFFirewall"
    // InternalEasyWall.g:347:1: ruleEFFirewall returns [EObject current=null] : (otherlv_0= 'firewall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) ) ( (lv_members_4_0= ruleEFMember ) )* ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )* otherlv_6= '}' ) ;
    public final EObject ruleEFFirewall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_defaultPolicy_3_0 = null;

        EObject lv_members_4_0 = null;

        EObject lv_ruleRefs_5_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:353:2: ( (otherlv_0= 'firewall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) ) ( (lv_members_4_0= ruleEFMember ) )* ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )* otherlv_6= '}' ) )
            // InternalEasyWall.g:354:2: (otherlv_0= 'firewall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) ) ( (lv_members_4_0= ruleEFMember ) )* ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )* otherlv_6= '}' )
            {
            // InternalEasyWall.g:354:2: (otherlv_0= 'firewall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) ) ( (lv_members_4_0= ruleEFMember ) )* ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )* otherlv_6= '}' )
            // InternalEasyWall.g:355:3: otherlv_0= 'firewall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) ) ( (lv_members_4_0= ruleEFMember ) )* ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFFirewallAccess().getFirewallKeyword_0());
              		
            }
            // InternalEasyWall.g:359:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEasyWall.g:360:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEasyWall.g:360:4: (lv_name_1_0= RULE_ID )
            // InternalEasyWall.g:361:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEFFirewallAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFFirewallRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFFirewallAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalEasyWall.g:381:3: ( (lv_defaultPolicy_3_0= ruleEFDefaultPolicy ) )
            // InternalEasyWall.g:382:4: (lv_defaultPolicy_3_0= ruleEFDefaultPolicy )
            {
            // InternalEasyWall.g:382:4: (lv_defaultPolicy_3_0= ruleEFDefaultPolicy )
            // InternalEasyWall.g:383:5: lv_defaultPolicy_3_0= ruleEFDefaultPolicy
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFFirewallAccess().getDefaultPolicyEFDefaultPolicyParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_defaultPolicy_3_0=ruleEFDefaultPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFFirewallRule());
              					}
              					set(
              						current,
              						"defaultPolicy",
              						lv_defaultPolicy_3_0,
              						"org.xtext.example.easywall.EasyWall.EFDefaultPolicy");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalEasyWall.g:400:3: ( (lv_members_4_0= ruleEFMember ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=23 && LA7_0<=24)||LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalEasyWall.g:401:4: (lv_members_4_0= ruleEFMember )
            	    {
            	    // InternalEasyWall.g:401:4: (lv_members_4_0= ruleEFMember )
            	    // InternalEasyWall.g:402:5: lv_members_4_0= ruleEFMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEFFirewallAccess().getMembersEFMemberParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_members_4_0=ruleEFMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEFFirewallRule());
            	      					}
            	      					add(
            	      						current,
            	      						"members",
            	      						lv_members_4_0,
            	      						"org.xtext.example.easywall.EasyWall.EFMember");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalEasyWall.g:419:3: ( (lv_ruleRefs_5_0= ruleEFRuleReference ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalEasyWall.g:420:4: (lv_ruleRefs_5_0= ruleEFRuleReference )
            	    {
            	    // InternalEasyWall.g:420:4: (lv_ruleRefs_5_0= ruleEFRuleReference )
            	    // InternalEasyWall.g:421:5: lv_ruleRefs_5_0= ruleEFRuleReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEFFirewallAccess().getRuleRefsEFRuleReferenceParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_ruleRefs_5_0=ruleEFRuleReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEFFirewallRule());
            	      					}
            	      					add(
            	      						current,
            	      						"ruleRefs",
            	      						lv_ruleRefs_5_0,
            	      						"org.xtext.example.easywall.EasyWall.EFRuleReference");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEFFirewallAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFFirewall"


    // $ANTLR start "entryRuleEFDefaultPolicy"
    // InternalEasyWall.g:446:1: entryRuleEFDefaultPolicy returns [EObject current=null] : iv_ruleEFDefaultPolicy= ruleEFDefaultPolicy EOF ;
    public final EObject entryRuleEFDefaultPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFDefaultPolicy = null;


        try {
            // InternalEasyWall.g:446:56: (iv_ruleEFDefaultPolicy= ruleEFDefaultPolicy EOF )
            // InternalEasyWall.g:447:2: iv_ruleEFDefaultPolicy= ruleEFDefaultPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFDefaultPolicyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFDefaultPolicy=ruleEFDefaultPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFDefaultPolicy; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFDefaultPolicy"


    // $ANTLR start "ruleEFDefaultPolicy"
    // InternalEasyWall.g:453:1: ruleEFDefaultPolicy returns [EObject current=null] : (otherlv_0= 'default' ( (lv_action_1_0= ruleEFDefaultAction ) ) otherlv_2= ';' ) ;
    public final EObject ruleEFDefaultPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_action_1_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:459:2: ( (otherlv_0= 'default' ( (lv_action_1_0= ruleEFDefaultAction ) ) otherlv_2= ';' ) )
            // InternalEasyWall.g:460:2: (otherlv_0= 'default' ( (lv_action_1_0= ruleEFDefaultAction ) ) otherlv_2= ';' )
            {
            // InternalEasyWall.g:460:2: (otherlv_0= 'default' ( (lv_action_1_0= ruleEFDefaultAction ) ) otherlv_2= ';' )
            // InternalEasyWall.g:461:3: otherlv_0= 'default' ( (lv_action_1_0= ruleEFDefaultAction ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFDefaultPolicyAccess().getDefaultKeyword_0());
              		
            }
            // InternalEasyWall.g:465:3: ( (lv_action_1_0= ruleEFDefaultAction ) )
            // InternalEasyWall.g:466:4: (lv_action_1_0= ruleEFDefaultAction )
            {
            // InternalEasyWall.g:466:4: (lv_action_1_0= ruleEFDefaultAction )
            // InternalEasyWall.g:467:5: lv_action_1_0= ruleEFDefaultAction
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFDefaultPolicyAccess().getActionEFDefaultActionEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_action_1_0=ruleEFDefaultAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFDefaultPolicyRule());
              					}
              					set(
              						current,
              						"action",
              						lv_action_1_0,
              						"org.xtext.example.easywall.EasyWall.EFDefaultAction");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFDefaultPolicyAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFDefaultPolicy"


    // $ANTLR start "entryRuleEFRuleReference"
    // InternalEasyWall.g:492:1: entryRuleEFRuleReference returns [EObject current=null] : iv_ruleEFRuleReference= ruleEFRuleReference EOF ;
    public final EObject entryRuleEFRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFRuleReference = null;


        try {
            // InternalEasyWall.g:492:56: (iv_ruleEFRuleReference= ruleEFRuleReference EOF )
            // InternalEasyWall.g:493:2: iv_ruleEFRuleReference= ruleEFRuleReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFRuleReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFRuleReference=ruleEFRuleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFRuleReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFRuleReference"


    // $ANTLR start "ruleEFRuleReference"
    // InternalEasyWall.g:499:1: ruleEFRuleReference returns [EObject current=null] : (otherlv_0= 'apply' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleEFRuleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalEasyWall.g:505:2: ( (otherlv_0= 'apply' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalEasyWall.g:506:2: (otherlv_0= 'apply' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalEasyWall.g:506:2: (otherlv_0= 'apply' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalEasyWall.g:507:3: otherlv_0= 'apply' ( ( ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFRuleReferenceAccess().getApplyKeyword_0());
              		
            }
            // InternalEasyWall.g:511:3: ( ( ruleQualifiedName ) )
            // InternalEasyWall.g:512:4: ( ruleQualifiedName )
            {
            // InternalEasyWall.g:512:4: ( ruleQualifiedName )
            // InternalEasyWall.g:513:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFRuleReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFRuleReferenceAccess().getRuleEFRuleClassCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFRuleReferenceAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRuleReference"


    // $ANTLR start "entryRuleEFMember"
    // InternalEasyWall.g:535:1: entryRuleEFMember returns [EObject current=null] : iv_ruleEFMember= ruleEFMember EOF ;
    public final EObject entryRuleEFMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFMember = null;


        try {
            // InternalEasyWall.g:535:49: (iv_ruleEFMember= ruleEFMember EOF )
            // InternalEasyWall.g:536:2: iv_ruleEFMember= ruleEFMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFMember=ruleEFMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFMember"


    // $ANTLR start "ruleEFMember"
    // InternalEasyWall.g:542:1: ruleEFMember returns [EObject current=null] : (this_EFField_0= ruleEFField | this_EFMethod_1= ruleEFMethod ) ;
    public final EObject ruleEFMember() throws RecognitionException {
        EObject current = null;

        EObject this_EFField_0 = null;

        EObject this_EFMethod_1 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:548:2: ( (this_EFField_0= ruleEFField | this_EFMethod_1= ruleEFMethod ) )
            // InternalEasyWall.g:549:2: (this_EFField_0= ruleEFField | this_EFMethod_1= ruleEFMethod )
            {
            // InternalEasyWall.g:549:2: (this_EFField_0= ruleEFField | this_EFMethod_1= ruleEFMethod )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=23 && LA9_0<=24)) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalEasyWall.g:550:3: this_EFField_0= ruleEFField
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFMemberAccess().getEFFieldParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFField_0=ruleEFField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFField_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:559:3: this_EFMethod_1= ruleEFMethod
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFMemberAccess().getEFMethodParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFMethod_1=ruleEFMethod();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFMethod_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFMember"


    // $ANTLR start "entryRuleEFField"
    // InternalEasyWall.g:571:1: entryRuleEFField returns [EObject current=null] : iv_ruleEFField= ruleEFField EOF ;
    public final EObject entryRuleEFField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFField = null;


        try {
            // InternalEasyWall.g:571:48: (iv_ruleEFField= ruleEFField EOF )
            // InternalEasyWall.g:572:2: iv_ruleEFField= ruleEFField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFField=ruleEFField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFField"


    // $ANTLR start "ruleEFField"
    // InternalEasyWall.g:578:1: ruleEFField returns [EObject current=null] : ( (otherlv_0= 'set' | otherlv_1= 'var' ) this_EFTypedDeclaration_2= ruleEFTypedDeclaration[$current] (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleEFField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_EFTypedDeclaration_2 = null;

        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:584:2: ( ( (otherlv_0= 'set' | otherlv_1= 'var' ) this_EFTypedDeclaration_2= ruleEFTypedDeclaration[$current] (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )? otherlv_5= ';' ) )
            // InternalEasyWall.g:585:2: ( (otherlv_0= 'set' | otherlv_1= 'var' ) this_EFTypedDeclaration_2= ruleEFTypedDeclaration[$current] (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )? otherlv_5= ';' )
            {
            // InternalEasyWall.g:585:2: ( (otherlv_0= 'set' | otherlv_1= 'var' ) this_EFTypedDeclaration_2= ruleEFTypedDeclaration[$current] (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )? otherlv_5= ';' )
            // InternalEasyWall.g:586:3: (otherlv_0= 'set' | otherlv_1= 'var' ) this_EFTypedDeclaration_2= ruleEFTypedDeclaration[$current] (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )? otherlv_5= ';'
            {
            // InternalEasyWall.g:586:3: (otherlv_0= 'set' | otherlv_1= 'var' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            else if ( (LA10_0==24) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalEasyWall.g:587:4: otherlv_0= 'set'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getEFFieldAccess().getSetKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:592:4: otherlv_1= 'var'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEFFieldAccess().getVarKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getEFFieldRule());
              			}
              			newCompositeNode(grammarAccess.getEFFieldAccess().getEFTypedDeclarationParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_15);
            this_EFTypedDeclaration_2=ruleEFTypedDeclaration(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFTypedDeclaration_2;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:608:3: (otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEasyWall.g:609:4: otherlv_3= '=' ( (lv_expression_4_0= ruleEFExpression ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getEFFieldAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalEasyWall.g:613:4: ( (lv_expression_4_0= ruleEFExpression ) )
                    // InternalEasyWall.g:614:5: (lv_expression_4_0= ruleEFExpression )
                    {
                    // InternalEasyWall.g:614:5: (lv_expression_4_0= ruleEFExpression )
                    // InternalEasyWall.g:615:6: lv_expression_4_0= ruleEFExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFFieldAccess().getExpressionEFExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    lv_expression_4_0=ruleEFExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFFieldRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_4_0,
                      							"org.xtext.example.easywall.EasyWall.EFExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getEFFieldAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFField"


    // $ANTLR start "ruleEFTypedDeclaration"
    // InternalEasyWall.g:642:1: ruleEFTypedDeclaration[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEFType ) ) ) ;
    public final EObject ruleEFTypedDeclaration(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:648:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEFType ) ) ) )
            // InternalEasyWall.g:649:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEFType ) ) )
            {
            // InternalEasyWall.g:649:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEFType ) ) )
            // InternalEasyWall.g:650:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleEFType ) )
            {
            // InternalEasyWall.g:650:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalEasyWall.g:651:4: (lv_name_0_0= RULE_ID )
            {
            // InternalEasyWall.g:651:4: (lv_name_0_0= RULE_ID )
            // InternalEasyWall.g:652:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEFTypedDeclarationAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFTypedDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEFTypedDeclarationAccess().getColonKeyword_1());
              		
            }
            // InternalEasyWall.g:672:3: ( (lv_type_2_0= ruleEFType ) )
            // InternalEasyWall.g:673:4: (lv_type_2_0= ruleEFType )
            {
            // InternalEasyWall.g:673:4: (lv_type_2_0= ruleEFType )
            // InternalEasyWall.g:674:5: lv_type_2_0= ruleEFType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFTypedDeclarationAccess().getTypeEFTypeEnumRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleEFType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFTypedDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"org.xtext.example.easywall.EasyWall.EFType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFTypedDeclaration"


    // $ANTLR start "entryRuleEFMethod"
    // InternalEasyWall.g:695:1: entryRuleEFMethod returns [EObject current=null] : iv_ruleEFMethod= ruleEFMethod EOF ;
    public final EObject entryRuleEFMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFMethod = null;


        try {
            // InternalEasyWall.g:695:49: (iv_ruleEFMethod= ruleEFMethod EOF )
            // InternalEasyWall.g:696:2: iv_ruleEFMethod= ruleEFMethod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFMethodRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFMethod=ruleEFMethod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFMethod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFMethod"


    // $ANTLR start "ruleEFMethod"
    // InternalEasyWall.g:702:1: ruleEFMethod returns [EObject current=null] : (otherlv_0= 'fun' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) ) ( (lv_body_10_0= ruleEFBlock ) ) ) ;
    public final EObject ruleEFMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_void_9_0=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        Enumerator lv_nativetype_8_0 = null;

        EObject lv_body_10_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:708:2: ( (otherlv_0= 'fun' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) ) ( (lv_body_10_0= ruleEFBlock ) ) ) )
            // InternalEasyWall.g:709:2: (otherlv_0= 'fun' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) ) ( (lv_body_10_0= ruleEFBlock ) ) )
            {
            // InternalEasyWall.g:709:2: (otherlv_0= 'fun' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) ) ( (lv_body_10_0= ruleEFBlock ) ) )
            // InternalEasyWall.g:710:3: otherlv_0= 'fun' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) ) ( (lv_body_10_0= ruleEFBlock ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFMethodAccess().getFunKeyword_0());
              		
            }
            // InternalEasyWall.g:714:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEasyWall.g:715:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEasyWall.g:715:4: (lv_name_1_0= RULE_ID )
            // InternalEasyWall.g:716:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEFMethodAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFMethodRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFMethodAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalEasyWall.g:736:3: ( ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalEasyWall.g:737:4: ( (lv_params_3_0= ruleEFParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )*
                    {
                    // InternalEasyWall.g:737:4: ( (lv_params_3_0= ruleEFParameter ) )
                    // InternalEasyWall.g:738:5: (lv_params_3_0= ruleEFParameter )
                    {
                    // InternalEasyWall.g:738:5: (lv_params_3_0= ruleEFParameter )
                    // InternalEasyWall.g:739:6: lv_params_3_0= ruleEFParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFMethodAccess().getParamsEFParameterParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_params_3_0=ruleEFParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFMethodRule());
                      						}
                      						add(
                      							current,
                      							"params",
                      							lv_params_3_0,
                      							"org.xtext.example.easywall.EasyWall.EFParameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalEasyWall.g:756:4: (otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==29) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalEasyWall.g:757:5: otherlv_4= ',' ( (lv_params_5_0= ruleEFParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getEFMethodAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalEasyWall.g:761:5: ( (lv_params_5_0= ruleEFParameter ) )
                    	    // InternalEasyWall.g:762:6: (lv_params_5_0= ruleEFParameter )
                    	    {
                    	    // InternalEasyWall.g:762:6: (lv_params_5_0= ruleEFParameter )
                    	    // InternalEasyWall.g:763:7: lv_params_5_0= ruleEFParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getEFMethodAccess().getParamsEFParameterParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_params_5_0=ruleEFParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getEFMethodRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"params",
                    	      								lv_params_5_0,
                    	      								"org.xtext.example.easywall.EasyWall.EFParameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEFMethodAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,26,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getEFMethodAccess().getColonKeyword_5());
              		
            }
            // InternalEasyWall.g:790:3: ( ( (lv_nativetype_8_0= ruleEFType ) ) | ( (lv_void_9_0= 'void' ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=69 && LA14_0<=77)) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalEasyWall.g:791:4: ( (lv_nativetype_8_0= ruleEFType ) )
                    {
                    // InternalEasyWall.g:791:4: ( (lv_nativetype_8_0= ruleEFType ) )
                    // InternalEasyWall.g:792:5: (lv_nativetype_8_0= ruleEFType )
                    {
                    // InternalEasyWall.g:792:5: (lv_nativetype_8_0= ruleEFType )
                    // InternalEasyWall.g:793:6: lv_nativetype_8_0= ruleEFType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFMethodAccess().getNativetypeEFTypeEnumRuleCall_6_0_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_nativetype_8_0=ruleEFType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFMethodRule());
                      						}
                      						set(
                      							current,
                      							"nativetype",
                      							lv_nativetype_8_0,
                      							"org.xtext.example.easywall.EasyWall.EFType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:811:4: ( (lv_void_9_0= 'void' ) )
                    {
                    // InternalEasyWall.g:811:4: ( (lv_void_9_0= 'void' ) )
                    // InternalEasyWall.g:812:5: (lv_void_9_0= 'void' )
                    {
                    // InternalEasyWall.g:812:5: (lv_void_9_0= 'void' )
                    // InternalEasyWall.g:813:6: lv_void_9_0= 'void'
                    {
                    lv_void_9_0=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_void_9_0, grammarAccess.getEFMethodAccess().getVoidVoidKeyword_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFMethodRule());
                      						}
                      						setWithLastConsumed(current, "void", lv_void_9_0, "void");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalEasyWall.g:826:3: ( (lv_body_10_0= ruleEFBlock ) )
            // InternalEasyWall.g:827:4: (lv_body_10_0= ruleEFBlock )
            {
            // InternalEasyWall.g:827:4: (lv_body_10_0= ruleEFBlock )
            // InternalEasyWall.g:828:5: lv_body_10_0= ruleEFBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFMethodAccess().getBodyEFBlockParserRuleCall_7_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_10_0=ruleEFBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFMethodRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_10_0,
              						"org.xtext.example.easywall.EasyWall.EFBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFMethod"


    // $ANTLR start "entryRuleEFParameter"
    // InternalEasyWall.g:849:1: entryRuleEFParameter returns [EObject current=null] : iv_ruleEFParameter= ruleEFParameter EOF ;
    public final EObject entryRuleEFParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFParameter = null;


        try {
            // InternalEasyWall.g:849:52: (iv_ruleEFParameter= ruleEFParameter EOF )
            // InternalEasyWall.g:850:2: iv_ruleEFParameter= ruleEFParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFParameter=ruleEFParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFParameter"


    // $ANTLR start "ruleEFParameter"
    // InternalEasyWall.g:856:1: ruleEFParameter returns [EObject current=null] : this_EFTypedDeclaration_0= ruleEFTypedDeclaration[$current] ;
    public final EObject ruleEFParameter() throws RecognitionException {
        EObject current = null;

        EObject this_EFTypedDeclaration_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:862:2: (this_EFTypedDeclaration_0= ruleEFTypedDeclaration[$current] )
            // InternalEasyWall.g:863:2: this_EFTypedDeclaration_0= ruleEFTypedDeclaration[$current]
            {
            if ( state.backtracking==0 ) {

              		if (current==null) {
              			current = createModelElement(grammarAccess.getEFParameterRule());
              		}
              		newCompositeNode(grammarAccess.getEFParameterAccess().getEFTypedDeclarationParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_EFTypedDeclaration_0=ruleEFTypedDeclaration(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_EFTypedDeclaration_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFParameter"


    // $ANTLR start "entryRuleEFBlock"
    // InternalEasyWall.g:877:1: entryRuleEFBlock returns [EObject current=null] : iv_ruleEFBlock= ruleEFBlock EOF ;
    public final EObject entryRuleEFBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFBlock = null;


        try {
            // InternalEasyWall.g:877:48: (iv_ruleEFBlock= ruleEFBlock EOF )
            // InternalEasyWall.g:878:2: iv_ruleEFBlock= ruleEFBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFBlock=ruleEFBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFBlock"


    // $ANTLR start "ruleEFBlock"
    // InternalEasyWall.g:884:1: ruleEFBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleEFStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleEFBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:890:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleEFStatement ) )* otherlv_3= '}' ) )
            // InternalEasyWall.g:891:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleEFStatement ) )* otherlv_3= '}' )
            {
            // InternalEasyWall.g:891:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleEFStatement ) )* otherlv_3= '}' )
            // InternalEasyWall.g:892:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleEFStatement ) )* otherlv_3= '}'
            {
            // InternalEasyWall.g:892:3: ()
            // InternalEasyWall.g:893:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEFBlockAccess().getEFBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,19,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEFBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalEasyWall.g:903:3: ( (lv_statements_2_0= ruleEFStatement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_EFIPV4SYNTAX)||(LA15_0>=23 && LA15_0<=24)||LA15_0==26||LA15_0==28||(LA15_0>=32 && LA15_0<=33)||(LA15_0>=36 && LA15_0<=47)||(LA15_0>=54 && LA15_0<=55)||(LA15_0>=78 && LA15_0<=80)||(LA15_0>=89 && LA15_0<=113)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalEasyWall.g:904:4: (lv_statements_2_0= ruleEFStatement )
            	    {
            	    // InternalEasyWall.g:904:4: (lv_statements_2_0= ruleEFStatement )
            	    // InternalEasyWall.g:905:5: lv_statements_2_0= ruleEFStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEFBlockAccess().getStatementsEFStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_statements_2_0=ruleEFStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEFBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"org.xtext.example.easywall.EasyWall.EFStatement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getEFBlockAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFBlock"


    // $ANTLR start "entryRuleEFStatement"
    // InternalEasyWall.g:930:1: entryRuleEFStatement returns [EObject current=null] : iv_ruleEFStatement= ruleEFStatement EOF ;
    public final EObject entryRuleEFStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFStatement = null;


        try {
            // InternalEasyWall.g:930:52: (iv_ruleEFStatement= ruleEFStatement EOF )
            // InternalEasyWall.g:931:2: iv_ruleEFStatement= ruleEFStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFStatement=ruleEFStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFStatement"


    // $ANTLR start "ruleEFStatement"
    // InternalEasyWall.g:937:1: ruleEFStatement returns [EObject current=null] : (this_EFField_0= ruleEFField | this_EFReturn_1= ruleEFReturn | (this_EFExpression_2= ruleEFExpression otherlv_3= ';' ) | this_EFIfStatement_4= ruleEFIfStatement ) ;
    public final EObject ruleEFStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_EFField_0 = null;

        EObject this_EFReturn_1 = null;

        EObject this_EFExpression_2 = null;

        EObject this_EFIfStatement_4 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:943:2: ( (this_EFField_0= ruleEFField | this_EFReturn_1= ruleEFReturn | (this_EFExpression_2= ruleEFExpression otherlv_3= ';' ) | this_EFIfStatement_4= ruleEFIfStatement ) )
            // InternalEasyWall.g:944:2: (this_EFField_0= ruleEFField | this_EFReturn_1= ruleEFReturn | (this_EFExpression_2= ruleEFExpression otherlv_3= ';' ) | this_EFIfStatement_4= ruleEFIfStatement )
            {
            // InternalEasyWall.g:944:2: (this_EFField_0= ruleEFField | this_EFReturn_1= ruleEFReturn | (this_EFExpression_2= ruleEFExpression otherlv_3= ';' ) | this_EFIfStatement_4= ruleEFIfStatement )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 23:
            case 24:
                {
                alt16=1;
                }
                break;
            case 32:
                {
                alt16=2;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case RULE_EFIPV6SYNTAX:
            case RULE_EFIPV4SYNTAX:
            case 26:
            case 28:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 54:
            case 55:
            case 78:
            case 79:
            case 80:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
                {
                alt16=3;
                }
                break;
            case 33:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalEasyWall.g:945:3: this_EFField_0= ruleEFField
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFStatementAccess().getEFFieldParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFField_0=ruleEFField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFField_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:954:3: this_EFReturn_1= ruleEFReturn
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFStatementAccess().getEFReturnParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFReturn_1=ruleEFReturn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFReturn_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:963:3: (this_EFExpression_2= ruleEFExpression otherlv_3= ';' )
                    {
                    // InternalEasyWall.g:963:3: (this_EFExpression_2= ruleEFExpression otherlv_3= ';' )
                    // InternalEasyWall.g:964:4: this_EFExpression_2= ruleEFExpression otherlv_3= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getEFStatementAccess().getEFExpressionParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_EFExpression_2=ruleEFExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_EFExpression_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getEFStatementAccess().getSemicolonKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:978:3: this_EFIfStatement_4= ruleEFIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFStatementAccess().getEFIfStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFIfStatement_4=ruleEFIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFIfStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFStatement"


    // $ANTLR start "entryRuleEFReturn"
    // InternalEasyWall.g:990:1: entryRuleEFReturn returns [EObject current=null] : iv_ruleEFReturn= ruleEFReturn EOF ;
    public final EObject entryRuleEFReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFReturn = null;


        try {
            // InternalEasyWall.g:990:49: (iv_ruleEFReturn= ruleEFReturn EOF )
            // InternalEasyWall.g:991:2: iv_ruleEFReturn= ruleEFReturn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFReturnRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFReturn=ruleEFReturn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFReturn; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFReturn"


    // $ANTLR start "ruleEFReturn"
    // InternalEasyWall.g:997:1: ruleEFReturn returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleEFExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleEFReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1003:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleEFExpression ) ) otherlv_2= ';' ) )
            // InternalEasyWall.g:1004:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleEFExpression ) ) otherlv_2= ';' )
            {
            // InternalEasyWall.g:1004:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleEFExpression ) ) otherlv_2= ';' )
            // InternalEasyWall.g:1005:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleEFExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFReturnAccess().getReturnKeyword_0());
              		
            }
            // InternalEasyWall.g:1009:3: ( (lv_expression_1_0= ruleEFExpression ) )
            // InternalEasyWall.g:1010:4: (lv_expression_1_0= ruleEFExpression )
            {
            // InternalEasyWall.g:1010:4: (lv_expression_1_0= ruleEFExpression )
            // InternalEasyWall.g:1011:5: lv_expression_1_0= ruleEFExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFReturnAccess().getExpressionEFExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_expression_1_0=ruleEFExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFReturnRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.xtext.example.easywall.EasyWall.EFExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFReturnAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFReturn"


    // $ANTLR start "entryRuleEFIfStatement"
    // InternalEasyWall.g:1036:1: entryRuleEFIfStatement returns [EObject current=null] : iv_ruleEFIfStatement= ruleEFIfStatement EOF ;
    public final EObject entryRuleEFIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFIfStatement = null;


        try {
            // InternalEasyWall.g:1036:54: (iv_ruleEFIfStatement= ruleEFIfStatement EOF )
            // InternalEasyWall.g:1037:2: iv_ruleEFIfStatement= ruleEFIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFIfStatement=ruleEFIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFIfStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFIfStatement"


    // $ANTLR start "ruleEFIfStatement"
    // InternalEasyWall.g:1043:1: ruleEFIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleEFExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleEFIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )? ) ;
    public final EObject ruleEFIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_2_0 = null;

        EObject lv_thenBlock_4_0 = null;

        EObject lv_elseBlock_6_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1049:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleEFExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleEFIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )? ) )
            // InternalEasyWall.g:1050:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleEFExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleEFIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )? )
            {
            // InternalEasyWall.g:1050:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleEFExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleEFIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )? )
            // InternalEasyWall.g:1051:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleEFExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleEFIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,28,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEFIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalEasyWall.g:1059:3: ( (lv_expression_2_0= ruleEFExpression ) )
            // InternalEasyWall.g:1060:4: (lv_expression_2_0= ruleEFExpression )
            {
            // InternalEasyWall.g:1060:4: (lv_expression_2_0= ruleEFExpression )
            // InternalEasyWall.g:1061:5: lv_expression_2_0= ruleEFExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFIfStatementAccess().getExpressionEFExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_expression_2_0=ruleEFExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFIfStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.xtext.example.easywall.EasyWall.EFExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getEFIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalEasyWall.g:1082:3: ( (lv_thenBlock_4_0= ruleEFIfBlock ) )
            // InternalEasyWall.g:1083:4: (lv_thenBlock_4_0= ruleEFIfBlock )
            {
            // InternalEasyWall.g:1083:4: (lv_thenBlock_4_0= ruleEFIfBlock )
            // InternalEasyWall.g:1084:5: lv_thenBlock_4_0= ruleEFIfBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFIfStatementAccess().getThenBlockEFIfBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_thenBlock_4_0=ruleEFIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFIfStatementRule());
              					}
              					set(
              						current,
              						"thenBlock",
              						lv_thenBlock_4_0,
              						"org.xtext.example.easywall.EasyWall.EFIfBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalEasyWall.g:1101:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred1_InternalEasyWall()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalEasyWall.g:1102:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleEFIfBlock ) )
                    {
                    // InternalEasyWall.g:1102:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalEasyWall.g:1103:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getEFIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalEasyWall.g:1109:4: ( (lv_elseBlock_6_0= ruleEFIfBlock ) )
                    // InternalEasyWall.g:1110:5: (lv_elseBlock_6_0= ruleEFIfBlock )
                    {
                    // InternalEasyWall.g:1110:5: (lv_elseBlock_6_0= ruleEFIfBlock )
                    // InternalEasyWall.g:1111:6: lv_elseBlock_6_0= ruleEFIfBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFIfStatementAccess().getElseBlockEFIfBlockParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseBlock_6_0=ruleEFIfBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_6_0,
                      							"org.xtext.example.easywall.EasyWall.EFIfBlock");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFIfStatement"


    // $ANTLR start "entryRuleEFIfBlock"
    // InternalEasyWall.g:1133:1: entryRuleEFIfBlock returns [EObject current=null] : iv_ruleEFIfBlock= ruleEFIfBlock EOF ;
    public final EObject entryRuleEFIfBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFIfBlock = null;


        try {
            // InternalEasyWall.g:1133:50: (iv_ruleEFIfBlock= ruleEFIfBlock EOF )
            // InternalEasyWall.g:1134:2: iv_ruleEFIfBlock= ruleEFIfBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFIfBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFIfBlock=ruleEFIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFIfBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFIfBlock"


    // $ANTLR start "ruleEFIfBlock"
    // InternalEasyWall.g:1140:1: ruleEFIfBlock returns [EObject current=null] : ( ( (lv_statements_0_0= ruleEFStatement ) ) | this_EFBlock_1= ruleEFBlock ) ;
    public final EObject ruleEFIfBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;

        EObject this_EFBlock_1 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1146:2: ( ( ( (lv_statements_0_0= ruleEFStatement ) ) | this_EFBlock_1= ruleEFBlock ) )
            // InternalEasyWall.g:1147:2: ( ( (lv_statements_0_0= ruleEFStatement ) ) | this_EFBlock_1= ruleEFBlock )
            {
            // InternalEasyWall.g:1147:2: ( ( (lv_statements_0_0= ruleEFStatement ) ) | this_EFBlock_1= ruleEFBlock )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_EFIPV4SYNTAX)||(LA18_0>=23 && LA18_0<=24)||LA18_0==26||LA18_0==28||(LA18_0>=32 && LA18_0<=33)||(LA18_0>=36 && LA18_0<=47)||(LA18_0>=54 && LA18_0<=55)||(LA18_0>=78 && LA18_0<=80)||(LA18_0>=89 && LA18_0<=113)) ) {
                alt18=1;
            }
            else if ( (LA18_0==19) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalEasyWall.g:1148:3: ( (lv_statements_0_0= ruleEFStatement ) )
                    {
                    // InternalEasyWall.g:1148:3: ( (lv_statements_0_0= ruleEFStatement ) )
                    // InternalEasyWall.g:1149:4: (lv_statements_0_0= ruleEFStatement )
                    {
                    // InternalEasyWall.g:1149:4: (lv_statements_0_0= ruleEFStatement )
                    // InternalEasyWall.g:1150:5: lv_statements_0_0= ruleEFStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEFIfBlockAccess().getStatementsEFStatementParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_statements_0_0=ruleEFStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEFIfBlockRule());
                      					}
                      					add(
                      						current,
                      						"statements",
                      						lv_statements_0_0,
                      						"org.xtext.example.easywall.EasyWall.EFStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:1168:3: this_EFBlock_1= ruleEFBlock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFIfBlockAccess().getEFBlockParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFBlock_1=ruleEFBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFBlock_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFIfBlock"


    // $ANTLR start "entryRuleEFExpression"
    // InternalEasyWall.g:1180:1: entryRuleEFExpression returns [EObject current=null] : iv_ruleEFExpression= ruleEFExpression EOF ;
    public final EObject entryRuleEFExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFExpression = null;


        try {
            // InternalEasyWall.g:1180:53: (iv_ruleEFExpression= ruleEFExpression EOF )
            // InternalEasyWall.g:1181:2: iv_ruleEFExpression= ruleEFExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFExpression=ruleEFExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFExpression"


    // $ANTLR start "ruleEFExpression"
    // InternalEasyWall.g:1187:1: ruleEFExpression returns [EObject current=null] : this_EFAssignment_0= ruleEFAssignment ;
    public final EObject ruleEFExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFAssignment_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1193:2: (this_EFAssignment_0= ruleEFAssignment )
            // InternalEasyWall.g:1194:2: this_EFAssignment_0= ruleEFAssignment
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getEFExpressionAccess().getEFAssignmentParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_EFAssignment_0=ruleEFAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_EFAssignment_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFExpression"


    // $ANTLR start "entryRuleEFAssignment"
    // InternalEasyWall.g:1205:1: entryRuleEFAssignment returns [EObject current=null] : iv_ruleEFAssignment= ruleEFAssignment EOF ;
    public final EObject entryRuleEFAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFAssignment = null;


        try {
            // InternalEasyWall.g:1205:53: (iv_ruleEFAssignment= ruleEFAssignment EOF )
            // InternalEasyWall.g:1206:2: iv_ruleEFAssignment= ruleEFAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFAssignment=ruleEFAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFAssignment"


    // $ANTLR start "ruleEFAssignment"
    // InternalEasyWall.g:1212:1: ruleEFAssignment returns [EObject current=null] : (this_EFOrExpression_0= ruleEFOrExpression ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )? ) ;
    public final EObject ruleEFAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EFOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1218:2: ( (this_EFOrExpression_0= ruleEFOrExpression ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )? ) )
            // InternalEasyWall.g:1219:2: (this_EFOrExpression_0= ruleEFOrExpression ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )? )
            {
            // InternalEasyWall.g:1219:2: (this_EFOrExpression_0= ruleEFOrExpression ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )? )
            // InternalEasyWall.g:1220:3: this_EFOrExpression_0= ruleEFOrExpression ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFAssignmentAccess().getEFOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_EFOrExpression_0=ruleEFOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1228:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalEasyWall.g:1229:4: () otherlv_2= '=' ( (lv_right_3_0= ruleEFAssignment ) )
                    {
                    // InternalEasyWall.g:1229:4: ()
                    // InternalEasyWall.g:1230:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getEFAssignmentAccess().getEFAssignmentLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEFAssignmentAccess().getEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalEasyWall.g:1240:4: ( (lv_right_3_0= ruleEFAssignment ) )
                    // InternalEasyWall.g:1241:5: (lv_right_3_0= ruleEFAssignment )
                    {
                    // InternalEasyWall.g:1241:5: (lv_right_3_0= ruleEFAssignment )
                    // InternalEasyWall.g:1242:6: lv_right_3_0= ruleEFAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFAssignmentAccess().getRightEFAssignmentParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleEFAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"org.xtext.example.easywall.EasyWall.EFAssignment");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFAssignment"


    // $ANTLR start "entryRuleEFOrExpression"
    // InternalEasyWall.g:1264:1: entryRuleEFOrExpression returns [EObject current=null] : iv_ruleEFOrExpression= ruleEFOrExpression EOF ;
    public final EObject entryRuleEFOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFOrExpression = null;


        try {
            // InternalEasyWall.g:1264:55: (iv_ruleEFOrExpression= ruleEFOrExpression EOF )
            // InternalEasyWall.g:1265:2: iv_ruleEFOrExpression= ruleEFOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFOrExpression=ruleEFOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFOrExpression"


    // $ANTLR start "ruleEFOrExpression"
    // InternalEasyWall.g:1271:1: ruleEFOrExpression returns [EObject current=null] : (this_EFAndExpression_0= ruleEFAndExpression ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )* ) ;
    public final EObject ruleEFOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1277:2: ( (this_EFAndExpression_0= ruleEFAndExpression ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )* ) )
            // InternalEasyWall.g:1278:2: (this_EFAndExpression_0= ruleEFAndExpression ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )* )
            {
            // InternalEasyWall.g:1278:2: (this_EFAndExpression_0= ruleEFAndExpression ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )* )
            // InternalEasyWall.g:1279:3: this_EFAndExpression_0= ruleEFAndExpression ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFOrExpressionAccess().getEFAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_EFAndExpression_0=ruleEFAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1287:3: ( () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=50 && LA20_0<=51)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalEasyWall.g:1288:4: () ruleEFOr ( (lv_right_3_0= ruleEFAndExpression ) )
            	    {
            	    // InternalEasyWall.g:1288:4: ()
            	    // InternalEasyWall.g:1289:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFOrExpressionAccess().getEFOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFOrExpressionAccess().getEFOrParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1302:4: ( (lv_right_3_0= ruleEFAndExpression ) )
            	    // InternalEasyWall.g:1303:5: (lv_right_3_0= ruleEFAndExpression )
            	    {
            	    // InternalEasyWall.g:1303:5: (lv_right_3_0= ruleEFAndExpression )
            	    // InternalEasyWall.g:1304:6: lv_right_3_0= ruleEFAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFOrExpressionAccess().getRightEFAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_right_3_0=ruleEFAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFOrExpression"


    // $ANTLR start "entryRuleEFAndExpression"
    // InternalEasyWall.g:1326:1: entryRuleEFAndExpression returns [EObject current=null] : iv_ruleEFAndExpression= ruleEFAndExpression EOF ;
    public final EObject entryRuleEFAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFAndExpression = null;


        try {
            // InternalEasyWall.g:1326:56: (iv_ruleEFAndExpression= ruleEFAndExpression EOF )
            // InternalEasyWall.g:1327:2: iv_ruleEFAndExpression= ruleEFAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFAndExpression=ruleEFAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFAndExpression"


    // $ANTLR start "ruleEFAndExpression"
    // InternalEasyWall.g:1333:1: ruleEFAndExpression returns [EObject current=null] : (this_EFEqualExpression_0= ruleEFEqualExpression ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )* ) ;
    public final EObject ruleEFAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFEqualExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1339:2: ( (this_EFEqualExpression_0= ruleEFEqualExpression ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )* ) )
            // InternalEasyWall.g:1340:2: (this_EFEqualExpression_0= ruleEFEqualExpression ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )* )
            {
            // InternalEasyWall.g:1340:2: (this_EFEqualExpression_0= ruleEFEqualExpression ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )* )
            // InternalEasyWall.g:1341:3: this_EFEqualExpression_0= ruleEFEqualExpression ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFAndExpressionAccess().getEFEqualExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_EFEqualExpression_0=ruleEFEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFEqualExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1349:3: ( () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=52 && LA21_0<=53)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalEasyWall.g:1350:4: () ruleEFAnd ( (lv_right_3_0= ruleEFEqualExpression ) )
            	    {
            	    // InternalEasyWall.g:1350:4: ()
            	    // InternalEasyWall.g:1351:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFAndExpressionAccess().getEFAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFAndExpressionAccess().getEFAndParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1364:4: ( (lv_right_3_0= ruleEFEqualExpression ) )
            	    // InternalEasyWall.g:1365:5: (lv_right_3_0= ruleEFEqualExpression )
            	    {
            	    // InternalEasyWall.g:1365:5: (lv_right_3_0= ruleEFEqualExpression )
            	    // InternalEasyWall.g:1366:6: lv_right_3_0= ruleEFEqualExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFAndExpressionAccess().getRightEFEqualExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleEFEqualExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFEqualExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFAndExpression"


    // $ANTLR start "entryRuleEFEqualExpression"
    // InternalEasyWall.g:1388:1: entryRuleEFEqualExpression returns [EObject current=null] : iv_ruleEFEqualExpression= ruleEFEqualExpression EOF ;
    public final EObject entryRuleEFEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFEqualExpression = null;


        try {
            // InternalEasyWall.g:1388:58: (iv_ruleEFEqualExpression= ruleEFEqualExpression EOF )
            // InternalEasyWall.g:1389:2: iv_ruleEFEqualExpression= ruleEFEqualExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFEqualExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFEqualExpression=ruleEFEqualExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFEqualExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFEqualExpression"


    // $ANTLR start "ruleEFEqualExpression"
    // InternalEasyWall.g:1395:1: ruleEFEqualExpression returns [EObject current=null] : (this_EFRelExpression_0= ruleEFRelExpression ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )* ) ;
    public final EObject ruleEFEqualExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFRelExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1401:2: ( (this_EFRelExpression_0= ruleEFRelExpression ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )* ) )
            // InternalEasyWall.g:1402:2: (this_EFRelExpression_0= ruleEFRelExpression ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )* )
            {
            // InternalEasyWall.g:1402:2: (this_EFRelExpression_0= ruleEFRelExpression ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )* )
            // InternalEasyWall.g:1403:3: this_EFRelExpression_0= ruleEFRelExpression ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFEqualExpressionAccess().getEFRelExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_EFRelExpression_0=ruleEFRelExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFRelExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1411:3: ( () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=56 && LA22_0<=58)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalEasyWall.g:1412:4: () ruleEFEqualOperators ( (lv_right_3_0= ruleEFRelExpression ) )
            	    {
            	    // InternalEasyWall.g:1412:4: ()
            	    // InternalEasyWall.g:1413:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFEqualExpressionAccess().getEFEqualExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFEqualExpressionAccess().getEFEqualOperatorsParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFEqualOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1426:4: ( (lv_right_3_0= ruleEFRelExpression ) )
            	    // InternalEasyWall.g:1427:5: (lv_right_3_0= ruleEFRelExpression )
            	    {
            	    // InternalEasyWall.g:1427:5: (lv_right_3_0= ruleEFRelExpression )
            	    // InternalEasyWall.g:1428:6: lv_right_3_0= ruleEFRelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFEqualExpressionAccess().getRightEFRelExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_right_3_0=ruleEFRelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFEqualExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFRelExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFEqualExpression"


    // $ANTLR start "entryRuleEFRelExpression"
    // InternalEasyWall.g:1450:1: entryRuleEFRelExpression returns [EObject current=null] : iv_ruleEFRelExpression= ruleEFRelExpression EOF ;
    public final EObject entryRuleEFRelExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFRelExpression = null;


        try {
            // InternalEasyWall.g:1450:56: (iv_ruleEFRelExpression= ruleEFRelExpression EOF )
            // InternalEasyWall.g:1451:2: iv_ruleEFRelExpression= ruleEFRelExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFRelExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFRelExpression=ruleEFRelExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFRelExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFRelExpression"


    // $ANTLR start "ruleEFRelExpression"
    // InternalEasyWall.g:1457:1: ruleEFRelExpression returns [EObject current=null] : (this_EFAddExpression_0= ruleEFAddExpression ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )* ) ;
    public final EObject ruleEFRelExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFAddExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1463:2: ( (this_EFAddExpression_0= ruleEFAddExpression ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )* ) )
            // InternalEasyWall.g:1464:2: (this_EFAddExpression_0= ruleEFAddExpression ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )* )
            {
            // InternalEasyWall.g:1464:2: (this_EFAddExpression_0= ruleEFAddExpression ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )* )
            // InternalEasyWall.g:1465:3: this_EFAddExpression_0= ruleEFAddExpression ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFRelExpressionAccess().getEFAddExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_EFAddExpression_0=ruleEFAddExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFAddExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1473:3: ( () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=59 && LA23_0<=62)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalEasyWall.g:1474:4: () ruleEFRelOperators ( (lv_right_3_0= ruleEFAddExpression ) )
            	    {
            	    // InternalEasyWall.g:1474:4: ()
            	    // InternalEasyWall.g:1475:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFRelExpressionAccess().getEFRelExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFRelExpressionAccess().getEFRelOperatorsParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFRelOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1488:4: ( (lv_right_3_0= ruleEFAddExpression ) )
            	    // InternalEasyWall.g:1489:5: (lv_right_3_0= ruleEFAddExpression )
            	    {
            	    // InternalEasyWall.g:1489:5: (lv_right_3_0= ruleEFAddExpression )
            	    // InternalEasyWall.g:1490:6: lv_right_3_0= ruleEFAddExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFRelExpressionAccess().getRightEFAddExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_right_3_0=ruleEFAddExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFRelExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFAddExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRelExpression"


    // $ANTLR start "entryRuleEFAddExpression"
    // InternalEasyWall.g:1512:1: entryRuleEFAddExpression returns [EObject current=null] : iv_ruleEFAddExpression= ruleEFAddExpression EOF ;
    public final EObject entryRuleEFAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFAddExpression = null;


        try {
            // InternalEasyWall.g:1512:56: (iv_ruleEFAddExpression= ruleEFAddExpression EOF )
            // InternalEasyWall.g:1513:2: iv_ruleEFAddExpression= ruleEFAddExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFAddExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFAddExpression=ruleEFAddExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFAddExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFAddExpression"


    // $ANTLR start "ruleEFAddExpression"
    // InternalEasyWall.g:1519:1: ruleEFAddExpression returns [EObject current=null] : (this_EFMultExpression_0= ruleEFMultExpression ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )* ) ;
    public final EObject ruleEFAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFMultExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1525:2: ( (this_EFMultExpression_0= ruleEFMultExpression ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )* ) )
            // InternalEasyWall.g:1526:2: (this_EFMultExpression_0= ruleEFMultExpression ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )* )
            {
            // InternalEasyWall.g:1526:2: (this_EFMultExpression_0= ruleEFMultExpression ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )* )
            // InternalEasyWall.g:1527:3: this_EFMultExpression_0= ruleEFMultExpression ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFAddExpressionAccess().getEFMultExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_EFMultExpression_0=ruleEFMultExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFMultExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1535:3: ( () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=63 && LA24_0<=64)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalEasyWall.g:1536:4: () ruleEFAddOperators ( (lv_right_3_0= ruleEFMultExpression ) )
            	    {
            	    // InternalEasyWall.g:1536:4: ()
            	    // InternalEasyWall.g:1537:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFAddExpressionAccess().getEFAddExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFAddExpressionAccess().getEFAddOperatorsParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFAddOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1550:4: ( (lv_right_3_0= ruleEFMultExpression ) )
            	    // InternalEasyWall.g:1551:5: (lv_right_3_0= ruleEFMultExpression )
            	    {
            	    // InternalEasyWall.g:1551:5: (lv_right_3_0= ruleEFMultExpression )
            	    // InternalEasyWall.g:1552:6: lv_right_3_0= ruleEFMultExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFAddExpressionAccess().getRightEFMultExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_right_3_0=ruleEFMultExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFAddExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFMultExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFAddExpression"


    // $ANTLR start "entryRuleEFMultExpression"
    // InternalEasyWall.g:1574:1: entryRuleEFMultExpression returns [EObject current=null] : iv_ruleEFMultExpression= ruleEFMultExpression EOF ;
    public final EObject entryRuleEFMultExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFMultExpression = null;


        try {
            // InternalEasyWall.g:1574:57: (iv_ruleEFMultExpression= ruleEFMultExpression EOF )
            // InternalEasyWall.g:1575:2: iv_ruleEFMultExpression= ruleEFMultExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFMultExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFMultExpression=ruleEFMultExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFMultExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFMultExpression"


    // $ANTLR start "ruleEFMultExpression"
    // InternalEasyWall.g:1581:1: ruleEFMultExpression returns [EObject current=null] : (this_EFUnaryExpression_0= ruleEFUnaryExpression ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )* ) ;
    public final EObject ruleEFMultExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EFUnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1587:2: ( (this_EFUnaryExpression_0= ruleEFUnaryExpression ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )* ) )
            // InternalEasyWall.g:1588:2: (this_EFUnaryExpression_0= ruleEFUnaryExpression ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )* )
            {
            // InternalEasyWall.g:1588:2: (this_EFUnaryExpression_0= ruleEFUnaryExpression ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )* )
            // InternalEasyWall.g:1589:3: this_EFUnaryExpression_0= ruleEFUnaryExpression ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFMultExpressionAccess().getEFUnaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_EFUnaryExpression_0=ruleEFUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFUnaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1597:3: ( () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=65 && LA25_0<=67)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalEasyWall.g:1598:4: () ruleEFMultOperators ( (lv_right_3_0= ruleEFUnaryExpression ) )
            	    {
            	    // InternalEasyWall.g:1598:4: ()
            	    // InternalEasyWall.g:1599:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFMultExpressionAccess().getEFMultExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getEFMultExpressionAccess().getEFMultOperatorsParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleEFMultOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalEasyWall.g:1612:4: ( (lv_right_3_0= ruleEFUnaryExpression ) )
            	    // InternalEasyWall.g:1613:5: (lv_right_3_0= ruleEFUnaryExpression )
            	    {
            	    // InternalEasyWall.g:1613:5: (lv_right_3_0= ruleEFUnaryExpression )
            	    // InternalEasyWall.g:1614:6: lv_right_3_0= ruleEFUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEFMultExpressionAccess().getRightEFUnaryExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_right_3_0=ruleEFUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEFMultExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.xtext.example.easywall.EasyWall.EFUnaryExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFMultExpression"


    // $ANTLR start "entryRuleEFUnaryExpression"
    // InternalEasyWall.g:1636:1: entryRuleEFUnaryExpression returns [EObject current=null] : iv_ruleEFUnaryExpression= ruleEFUnaryExpression EOF ;
    public final EObject entryRuleEFUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFUnaryExpression = null;


        try {
            // InternalEasyWall.g:1636:58: (iv_ruleEFUnaryExpression= ruleEFUnaryExpression EOF )
            // InternalEasyWall.g:1637:2: iv_ruleEFUnaryExpression= ruleEFUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFUnaryExpression=ruleEFUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFUnaryExpression"


    // $ANTLR start "ruleEFUnaryExpression"
    // InternalEasyWall.g:1643:1: ruleEFUnaryExpression returns [EObject current=null] : ( ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) ) | this_EFMemberSelection_3= ruleEFMemberSelection ) ;
    public final EObject ruleEFUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_2_0 = null;

        EObject this_EFMemberSelection_3 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1649:2: ( ( ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) ) | this_EFMemberSelection_3= ruleEFMemberSelection ) )
            // InternalEasyWall.g:1650:2: ( ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) ) | this_EFMemberSelection_3= ruleEFMemberSelection )
            {
            // InternalEasyWall.g:1650:2: ( ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) ) | this_EFMemberSelection_3= ruleEFMemberSelection )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=54 && LA26_0<=55)) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_EFIPV4SYNTAX)||LA26_0==26||LA26_0==28||(LA26_0>=36 && LA26_0<=47)||(LA26_0>=78 && LA26_0<=80)||(LA26_0>=89 && LA26_0<=113)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalEasyWall.g:1651:3: ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) )
                    {
                    // InternalEasyWall.g:1651:3: ( () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) ) )
                    // InternalEasyWall.g:1652:4: () ruleEFNot ( (lv_expression_2_0= ruleEFUnaryExpression ) )
                    {
                    // InternalEasyWall.g:1652:4: ()
                    // InternalEasyWall.g:1653:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFUnaryExpressionAccess().getEFNotExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getEFUnaryExpressionAccess().getEFNotParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_16);
                    ruleEFNot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalEasyWall.g:1666:4: ( (lv_expression_2_0= ruleEFUnaryExpression ) )
                    // InternalEasyWall.g:1667:5: (lv_expression_2_0= ruleEFUnaryExpression )
                    {
                    // InternalEasyWall.g:1667:5: (lv_expression_2_0= ruleEFUnaryExpression )
                    // InternalEasyWall.g:1668:6: lv_expression_2_0= ruleEFUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFUnaryExpressionAccess().getExpressionEFUnaryExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleEFUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"org.xtext.example.easywall.EasyWall.EFUnaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:1687:3: this_EFMemberSelection_3= ruleEFMemberSelection
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFUnaryExpressionAccess().getEFMemberSelectionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFMemberSelection_3=ruleEFMemberSelection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFMemberSelection_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFUnaryExpression"


    // $ANTLR start "entryRuleEFMemberSelection"
    // InternalEasyWall.g:1699:1: entryRuleEFMemberSelection returns [EObject current=null] : iv_ruleEFMemberSelection= ruleEFMemberSelection EOF ;
    public final EObject entryRuleEFMemberSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFMemberSelection = null;


        try {
            // InternalEasyWall.g:1699:58: (iv_ruleEFMemberSelection= ruleEFMemberSelection EOF )
            // InternalEasyWall.g:1700:2: iv_ruleEFMemberSelection= ruleEFMemberSelection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFMemberSelectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFMemberSelection=ruleEFMemberSelection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFMemberSelection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFMemberSelection"


    // $ANTLR start "ruleEFMemberSelection"
    // InternalEasyWall.g:1706:1: ruleEFMemberSelection returns [EObject current=null] : (this_EFPrimaryExpression_0= ruleEFPrimaryExpression ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )* ) ;
    public final EObject ruleEFMemberSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_EFPrimaryExpression_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1712:2: ( (this_EFPrimaryExpression_0= ruleEFPrimaryExpression ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )* ) )
            // InternalEasyWall.g:1713:2: (this_EFPrimaryExpression_0= ruleEFPrimaryExpression ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )* )
            {
            // InternalEasyWall.g:1713:2: (this_EFPrimaryExpression_0= ruleEFPrimaryExpression ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )* )
            // InternalEasyWall.g:1714:3: this_EFPrimaryExpression_0= ruleEFPrimaryExpression ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEFMemberSelectionAccess().getEFPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_EFPrimaryExpression_0=ruleEFPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EFPrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalEasyWall.g:1722:3: ( () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )? )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==35) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalEasyWall.g:1723:4: () otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )?
            	    {
            	    // InternalEasyWall.g:1723:4: ()
            	    // InternalEasyWall.g:1724:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEFMemberSelectionAccess().getEFMemberSelectionReceiverAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getEFMemberSelectionAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	      			
            	    }
            	    // InternalEasyWall.g:1734:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalEasyWall.g:1735:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalEasyWall.g:1735:5: (otherlv_3= RULE_ID )
            	    // InternalEasyWall.g:1736:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getEFMemberSelectionRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getEFMemberSelectionAccess().getMemberEFMemberCrossReference_1_2_0());
            	      					
            	    }

            	    }


            	    }

            	    // InternalEasyWall.g:1747:4: (otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==28) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // InternalEasyWall.g:1748:5: otherlv_4= '(' ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )? otherlv_8= ')'
            	            {
            	            otherlv_4=(Token)match(input,28,FOLLOW_36); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_4, grammarAccess.getEFMemberSelectionAccess().getLeftParenthesisKeyword_1_3_0());
            	              				
            	            }
            	            // InternalEasyWall.g:1752:5: ( ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )* )?
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_EFIPV4SYNTAX)||LA28_0==26||LA28_0==28||(LA28_0>=36 && LA28_0<=47)||(LA28_0>=54 && LA28_0<=55)||(LA28_0>=78 && LA28_0<=80)||(LA28_0>=89 && LA28_0<=113)) ) {
            	                alt28=1;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // InternalEasyWall.g:1753:6: ( (lv_args_5_0= ruleEFExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )*
            	                    {
            	                    // InternalEasyWall.g:1753:6: ( (lv_args_5_0= ruleEFExpression ) )
            	                    // InternalEasyWall.g:1754:7: (lv_args_5_0= ruleEFExpression )
            	                    {
            	                    // InternalEasyWall.g:1754:7: (lv_args_5_0= ruleEFExpression )
            	                    // InternalEasyWall.g:1755:8: lv_args_5_0= ruleEFExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      								newCompositeNode(grammarAccess.getEFMemberSelectionAccess().getArgsEFExpressionParserRuleCall_1_3_1_0_0());
            	                      							
            	                    }
            	                    pushFollow(FOLLOW_21);
            	                    lv_args_5_0=ruleEFExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      								if (current==null) {
            	                      									current = createModelElementForParent(grammarAccess.getEFMemberSelectionRule());
            	                      								}
            	                      								add(
            	                      									current,
            	                      									"args",
            	                      									lv_args_5_0,
            	                      									"org.xtext.example.easywall.EasyWall.EFExpression");
            	                      								afterParserOrEnumRuleCall();
            	                      							
            	                    }

            	                    }


            	                    }

            	                    // InternalEasyWall.g:1772:6: (otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) ) )*
            	                    loop27:
            	                    do {
            	                        int alt27=2;
            	                        int LA27_0 = input.LA(1);

            	                        if ( (LA27_0==29) ) {
            	                            alt27=1;
            	                        }


            	                        switch (alt27) {
            	                    	case 1 :
            	                    	    // InternalEasyWall.g:1773:7: otherlv_6= ',' ( (lv_args_7_0= ruleEFExpression ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      							newLeafNode(otherlv_6, grammarAccess.getEFMemberSelectionAccess().getCommaKeyword_1_3_1_1_0());
            	                    	      						
            	                    	    }
            	                    	    // InternalEasyWall.g:1777:7: ( (lv_args_7_0= ruleEFExpression ) )
            	                    	    // InternalEasyWall.g:1778:8: (lv_args_7_0= ruleEFExpression )
            	                    	    {
            	                    	    // InternalEasyWall.g:1778:8: (lv_args_7_0= ruleEFExpression )
            	                    	    // InternalEasyWall.g:1779:9: lv_args_7_0= ruleEFExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									newCompositeNode(grammarAccess.getEFMemberSelectionAccess().getArgsEFExpressionParserRuleCall_1_3_1_1_1_0());
            	                    	      								
            	                    	    }
            	                    	    pushFollow(FOLLOW_21);
            	                    	    lv_args_7_0=ruleEFExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									if (current==null) {
            	                    	      										current = createModelElementForParent(grammarAccess.getEFMemberSelectionRule());
            	                    	      									}
            	                    	      									add(
            	                    	      										current,
            	                    	      										"args",
            	                    	      										lv_args_7_0,
            	                    	      										"org.xtext.example.easywall.EasyWall.EFExpression");
            	                    	      									afterParserOrEnumRuleCall();
            	                    	      								
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop27;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,30,FOLLOW_34); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_8, grammarAccess.getEFMemberSelectionAccess().getRightParenthesisKeyword_1_3_2());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFMemberSelection"


    // $ANTLR start "entryRuleEFPrimaryExpression"
    // InternalEasyWall.g:1808:1: entryRuleEFPrimaryExpression returns [EObject current=null] : iv_ruleEFPrimaryExpression= ruleEFPrimaryExpression EOF ;
    public final EObject entryRuleEFPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFPrimaryExpression = null;


        try {
            // InternalEasyWall.g:1808:60: (iv_ruleEFPrimaryExpression= ruleEFPrimaryExpression EOF )
            // InternalEasyWall.g:1809:2: iv_ruleEFPrimaryExpression= ruleEFPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFPrimaryExpression=ruleEFPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFPrimaryExpression"


    // $ANTLR start "ruleEFPrimaryExpression"
    // InternalEasyWall.g:1815:1: ruleEFPrimaryExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | ( () ( (lv_value_3_0= RULE_INT ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) ) | ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) ) | ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) ) | ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) ) | ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) ) | ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) ) | ( () otherlv_26= 'this' ) | ( () otherlv_28= 'super' ) | ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' ) | ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' ) | this_EFBuiltinFunction_38= ruleEFBuiltinFunction | ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' ) | ( () ( ( ruleQualifiedName ) ) ) ) ;
    public final EObject ruleEFPrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token lv_ipv6_15_0=null;
        Token lv_ipv4_17_0=null;
        Token lv_any_18_0=null;
        Token lv_localhost_19_0=null;
        Token otherlv_23=null;
        Token lv_netport_24_0=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Enumerator lv_direction_7_0 = null;

        Enumerator lv_protocol_9_0 = null;

        Enumerator lv_protocol_11_0 = null;

        Enumerator lv_protocol_13_0 = null;

        EObject lv_network_21_0 = null;

        EObject lv_expression_36_0 = null;

        EObject this_EFBuiltinFunction_38 = null;

        AntlrDatatypeRuleToken lv_functionName_40_0 = null;

        EObject lv_args_42_0 = null;

        EObject lv_args_44_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:1821:2: ( ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | ( () ( (lv_value_3_0= RULE_INT ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) ) | ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) ) | ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) ) | ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) ) | ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) ) | ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) ) | ( () otherlv_26= 'this' ) | ( () otherlv_28= 'super' ) | ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' ) | ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' ) | this_EFBuiltinFunction_38= ruleEFBuiltinFunction | ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' ) | ( () ( ( ruleQualifiedName ) ) ) ) )
            // InternalEasyWall.g:1822:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | ( () ( (lv_value_3_0= RULE_INT ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) ) | ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) ) | ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) ) | ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) ) | ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) ) | ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) ) | ( () otherlv_26= 'this' ) | ( () otherlv_28= 'super' ) | ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' ) | ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' ) | this_EFBuiltinFunction_38= ruleEFBuiltinFunction | ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' ) | ( () ( ( ruleQualifiedName ) ) ) )
            {
            // InternalEasyWall.g:1822:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | ( () ( (lv_value_3_0= RULE_INT ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) ) | ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) ) | ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) ) | ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) ) | ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) ) | ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) ) | ( () otherlv_26= 'this' ) | ( () otherlv_28= 'super' ) | ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' ) | ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' ) | this_EFBuiltinFunction_38= ruleEFBuiltinFunction | ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' ) | ( () ( ( ruleQualifiedName ) ) ) )
            int alt35=18;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalEasyWall.g:1823:3: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    {
                    // InternalEasyWall.g:1823:3: ( () ( (lv_value_1_0= RULE_STRING ) ) )
                    // InternalEasyWall.g:1824:4: () ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // InternalEasyWall.g:1824:4: ()
                    // InternalEasyWall.g:1825:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFStringConstantAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1831:4: ( (lv_value_1_0= RULE_STRING ) )
                    // InternalEasyWall.g:1832:5: (lv_value_1_0= RULE_STRING )
                    {
                    // InternalEasyWall.g:1832:5: (lv_value_1_0= RULE_STRING )
                    // InternalEasyWall.g:1833:6: lv_value_1_0= RULE_STRING
                    {
                    lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getEFPrimaryExpressionAccess().getValueSTRINGTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:1851:3: ( () ( (lv_value_3_0= RULE_INT ) ) )
                    {
                    // InternalEasyWall.g:1851:3: ( () ( (lv_value_3_0= RULE_INT ) ) )
                    // InternalEasyWall.g:1852:4: () ( (lv_value_3_0= RULE_INT ) )
                    {
                    // InternalEasyWall.g:1852:4: ()
                    // InternalEasyWall.g:1853:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFIntConstantAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1859:4: ( (lv_value_3_0= RULE_INT ) )
                    // InternalEasyWall.g:1860:5: (lv_value_3_0= RULE_INT )
                    {
                    // InternalEasyWall.g:1860:5: (lv_value_3_0= RULE_INT )
                    // InternalEasyWall.g:1861:6: lv_value_3_0= RULE_INT
                    {
                    lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getEFPrimaryExpressionAccess().getValueINTTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:1879:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalEasyWall.g:1879:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalEasyWall.g:1880:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalEasyWall.g:1880:4: ()
                    // InternalEasyWall.g:1881:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFBoolConstantAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1887:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalEasyWall.g:1888:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalEasyWall.g:1888:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalEasyWall.g:1889:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalEasyWall.g:1889:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==36) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==37) ) {
                        alt31=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalEasyWall.g:1890:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_1, grammarAccess.getEFPrimaryExpressionAccess().getValueTrueKeyword_2_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_5_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalEasyWall.g:1901:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_2, grammarAccess.getEFPrimaryExpressionAccess().getValueFalseKeyword_2_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_5_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:1916:3: ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) )
                    {
                    // InternalEasyWall.g:1916:3: ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) )
                    // InternalEasyWall.g:1917:4: () ( (lv_direction_7_0= ruleEFDirectionNativeType ) )
                    {
                    // InternalEasyWall.g:1917:4: ()
                    // InternalEasyWall.g:1918:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFDirectionConstantAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1924:4: ( (lv_direction_7_0= ruleEFDirectionNativeType ) )
                    // InternalEasyWall.g:1925:5: (lv_direction_7_0= ruleEFDirectionNativeType )
                    {
                    // InternalEasyWall.g:1925:5: (lv_direction_7_0= ruleEFDirectionNativeType )
                    // InternalEasyWall.g:1926:6: lv_direction_7_0= ruleEFDirectionNativeType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getDirectionEFDirectionNativeTypeEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_direction_7_0=ruleEFDirectionNativeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"direction",
                      							lv_direction_7_0,
                      							"org.xtext.example.easywall.EasyWall.EFDirectionNativeType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:1945:3: ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) )
                    {
                    // InternalEasyWall.g:1945:3: ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) )
                    // InternalEasyWall.g:1946:4: () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) )
                    {
                    // InternalEasyWall.g:1946:4: ()
                    // InternalEasyWall.g:1947:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFNetworkProtocolConstantAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1953:4: ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) )
                    // InternalEasyWall.g:1954:5: (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL )
                    {
                    // InternalEasyWall.g:1954:5: (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL )
                    // InternalEasyWall.g:1955:6: lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getProtocolNETWORKLAYERPROTOCOLEnumRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_protocol_9_0=ruleNETWORKLAYERPROTOCOL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"protocol",
                      							lv_protocol_9_0,
                      							"org.xtext.example.easywall.EasyWall.NETWORKLAYERPROTOCOL");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalEasyWall.g:1974:3: ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) )
                    {
                    // InternalEasyWall.g:1974:3: ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) )
                    // InternalEasyWall.g:1975:4: () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) )
                    {
                    // InternalEasyWall.g:1975:4: ()
                    // InternalEasyWall.g:1976:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFTransportProtocolConstantAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:1982:4: ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) )
                    // InternalEasyWall.g:1983:5: (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL )
                    {
                    // InternalEasyWall.g:1983:5: (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL )
                    // InternalEasyWall.g:1984:6: lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getProtocolTRANSPORTLAYERPROTOCOLEnumRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_protocol_11_0=ruleTRANSPORTLAYERPROTOCOL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"protocol",
                      							lv_protocol_11_0,
                      							"org.xtext.example.easywall.EasyWall.TRANSPORTLAYERPROTOCOL");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalEasyWall.g:2003:3: ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) )
                    {
                    // InternalEasyWall.g:2003:3: ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) )
                    // InternalEasyWall.g:2004:4: () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) )
                    {
                    // InternalEasyWall.g:2004:4: ()
                    // InternalEasyWall.g:2005:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFApplicationProtocolConstantAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2011:4: ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) )
                    // InternalEasyWall.g:2012:5: (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL )
                    {
                    // InternalEasyWall.g:2012:5: (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL )
                    // InternalEasyWall.g:2013:6: lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getProtocolAPPLICATIONLAYERPROTOCOLEnumRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_protocol_13_0=ruleAPPLICATIONLAYERPROTOCOL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"protocol",
                      							lv_protocol_13_0,
                      							"org.xtext.example.easywall.EasyWall.APPLICATIONLAYERPROTOCOL");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalEasyWall.g:2032:3: ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) )
                    {
                    // InternalEasyWall.g:2032:3: ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) )
                    // InternalEasyWall.g:2033:4: () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) )
                    {
                    // InternalEasyWall.g:2033:4: ()
                    // InternalEasyWall.g:2034:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFIPv6ConstantAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2040:4: ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) )
                    // InternalEasyWall.g:2041:5: (lv_ipv6_15_0= RULE_EFIPV6SYNTAX )
                    {
                    // InternalEasyWall.g:2041:5: (lv_ipv6_15_0= RULE_EFIPV6SYNTAX )
                    // InternalEasyWall.g:2042:6: lv_ipv6_15_0= RULE_EFIPV6SYNTAX
                    {
                    lv_ipv6_15_0=(Token)match(input,RULE_EFIPV6SYNTAX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_ipv6_15_0, grammarAccess.getEFPrimaryExpressionAccess().getIpv6EFIPV6SYNTAXTerminalRuleCall_7_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"ipv6",
                      							lv_ipv6_15_0,
                      							"org.xtext.example.easywall.EasyWall.EFIPV6SYNTAX");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalEasyWall.g:2060:3: ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) )
                    {
                    // InternalEasyWall.g:2060:3: ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) )
                    // InternalEasyWall.g:2061:4: () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) )
                    {
                    // InternalEasyWall.g:2061:4: ()
                    // InternalEasyWall.g:2062:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFIPv4ConstantAction_8_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2068:4: ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) )
                    int alt32=3;
                    switch ( input.LA(1) ) {
                    case RULE_EFIPV4SYNTAX:
                        {
                        alt32=1;
                        }
                        break;
                    case 38:
                        {
                        alt32=2;
                        }
                        break;
                    case 39:
                        {
                        alt32=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }

                    switch (alt32) {
                        case 1 :
                            // InternalEasyWall.g:2069:5: ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) )
                            {
                            // InternalEasyWall.g:2069:5: ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) )
                            // InternalEasyWall.g:2070:6: (lv_ipv4_17_0= RULE_EFIPV4SYNTAX )
                            {
                            // InternalEasyWall.g:2070:6: (lv_ipv4_17_0= RULE_EFIPV4SYNTAX )
                            // InternalEasyWall.g:2071:7: lv_ipv4_17_0= RULE_EFIPV4SYNTAX
                            {
                            lv_ipv4_17_0=(Token)match(input,RULE_EFIPV4SYNTAX,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_ipv4_17_0, grammarAccess.getEFPrimaryExpressionAccess().getIpv4EFIPV4SYNTAXTerminalRuleCall_8_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"ipv4",
                              								lv_ipv4_17_0,
                              								"org.xtext.example.easywall.EasyWall.EFIPV4SYNTAX");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalEasyWall.g:2088:5: ( (lv_any_18_0= 'any' ) )
                            {
                            // InternalEasyWall.g:2088:5: ( (lv_any_18_0= 'any' ) )
                            // InternalEasyWall.g:2089:6: (lv_any_18_0= 'any' )
                            {
                            // InternalEasyWall.g:2089:6: (lv_any_18_0= 'any' )
                            // InternalEasyWall.g:2090:7: lv_any_18_0= 'any'
                            {
                            lv_any_18_0=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_any_18_0, grammarAccess.getEFPrimaryExpressionAccess().getAnyAnyKeyword_8_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							setWithLastConsumed(current, "any", lv_any_18_0, "any");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalEasyWall.g:2103:5: ( (lv_localhost_19_0= 'localhost' ) )
                            {
                            // InternalEasyWall.g:2103:5: ( (lv_localhost_19_0= 'localhost' ) )
                            // InternalEasyWall.g:2104:6: (lv_localhost_19_0= 'localhost' )
                            {
                            // InternalEasyWall.g:2104:6: (lv_localhost_19_0= 'localhost' )
                            // InternalEasyWall.g:2105:7: lv_localhost_19_0= 'localhost'
                            {
                            lv_localhost_19_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_localhost_19_0, grammarAccess.getEFPrimaryExpressionAccess().getLocalhostLocalhostKeyword_8_1_2_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							setWithLastConsumed(current, "localhost", lv_localhost_19_0, "localhost");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalEasyWall.g:2120:3: ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) )
                    {
                    // InternalEasyWall.g:2120:3: ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) )
                    // InternalEasyWall.g:2121:4: () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) )
                    {
                    // InternalEasyWall.g:2121:4: ()
                    // InternalEasyWall.g:2122:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFNetworkConstantAction_9_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2128:4: ( (lv_network_21_0= ruleEFNetworkSYNTAX ) )
                    // InternalEasyWall.g:2129:5: (lv_network_21_0= ruleEFNetworkSYNTAX )
                    {
                    // InternalEasyWall.g:2129:5: (lv_network_21_0= ruleEFNetworkSYNTAX )
                    // InternalEasyWall.g:2130:6: lv_network_21_0= ruleEFNetworkSYNTAX
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getNetworkEFNetworkSYNTAXParserRuleCall_9_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_network_21_0=ruleEFNetworkSYNTAX();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"network",
                      							lv_network_21_0,
                      							"org.xtext.example.easywall.EasyWall.EFNetworkSYNTAX");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalEasyWall.g:2149:3: ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) )
                    {
                    // InternalEasyWall.g:2149:3: ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) )
                    // InternalEasyWall.g:2150:4: () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) )
                    {
                    // InternalEasyWall.g:2150:4: ()
                    // InternalEasyWall.g:2151:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFNetportConstantAction_10_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_23=(Token)match(input,26,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getEFPrimaryExpressionAccess().getColonKeyword_10_1());
                      			
                    }
                    // InternalEasyWall.g:2161:4: ( (lv_netport_24_0= RULE_INT ) )
                    // InternalEasyWall.g:2162:5: (lv_netport_24_0= RULE_INT )
                    {
                    // InternalEasyWall.g:2162:5: (lv_netport_24_0= RULE_INT )
                    // InternalEasyWall.g:2163:6: lv_netport_24_0= RULE_INT
                    {
                    lv_netport_24_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_netport_24_0, grammarAccess.getEFPrimaryExpressionAccess().getNetportINTTerminalRuleCall_10_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"netport",
                      							lv_netport_24_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalEasyWall.g:2181:3: ( () otherlv_26= 'this' )
                    {
                    // InternalEasyWall.g:2181:3: ( () otherlv_26= 'this' )
                    // InternalEasyWall.g:2182:4: () otherlv_26= 'this'
                    {
                    // InternalEasyWall.g:2182:4: ()
                    // InternalEasyWall.g:2183:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFThisAction_11_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_26=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_26, grammarAccess.getEFPrimaryExpressionAccess().getThisKeyword_11_1());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalEasyWall.g:2195:3: ( () otherlv_28= 'super' )
                    {
                    // InternalEasyWall.g:2195:3: ( () otherlv_28= 'super' )
                    // InternalEasyWall.g:2196:4: () otherlv_28= 'super'
                    {
                    // InternalEasyWall.g:2196:4: ()
                    // InternalEasyWall.g:2197:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFSuperAction_12_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_28=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_28, grammarAccess.getEFPrimaryExpressionAccess().getSuperKeyword_12_1());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalEasyWall.g:2209:3: ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' )
                    {
                    // InternalEasyWall.g:2209:3: ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' )
                    // InternalEasyWall.g:2210:4: () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')'
                    {
                    // InternalEasyWall.g:2210:4: ()
                    // InternalEasyWall.g:2211:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFNewAction_13_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_30=(Token)match(input,42,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_30, grammarAccess.getEFPrimaryExpressionAccess().getNewKeyword_13_1());
                      			
                    }
                    // InternalEasyWall.g:2221:4: ( ( ruleQualifiedName ) )
                    // InternalEasyWall.g:2222:5: ( ruleQualifiedName )
                    {
                    // InternalEasyWall.g:2222:5: ( ruleQualifiedName )
                    // InternalEasyWall.g:2223:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getTypeEFRuleClassCrossReference_13_2_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_32=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_32, grammarAccess.getEFPrimaryExpressionAccess().getLeftParenthesisKeyword_13_3());
                      			
                    }
                    otherlv_33=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_33, grammarAccess.getEFPrimaryExpressionAccess().getRightParenthesisKeyword_13_4());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalEasyWall.g:2247:3: ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' )
                    {
                    // InternalEasyWall.g:2247:3: ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' )
                    // InternalEasyWall.g:2248:4: () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')'
                    {
                    // InternalEasyWall.g:2248:4: ()
                    // InternalEasyWall.g:2249:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFBracketsExpressionAction_14_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_35=(Token)match(input,28,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_35, grammarAccess.getEFPrimaryExpressionAccess().getLeftParenthesisKeyword_14_1());
                      			
                    }
                    // InternalEasyWall.g:2259:4: ( (lv_expression_36_0= ruleEFExpression ) )
                    // InternalEasyWall.g:2260:5: (lv_expression_36_0= ruleEFExpression )
                    {
                    // InternalEasyWall.g:2260:5: (lv_expression_36_0= ruleEFExpression )
                    // InternalEasyWall.g:2261:6: lv_expression_36_0= ruleEFExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getExpressionEFExpressionParserRuleCall_14_2_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_expression_36_0=ruleEFExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_36_0,
                      							"org.xtext.example.easywall.EasyWall.EFExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_37=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_37, grammarAccess.getEFPrimaryExpressionAccess().getRightParenthesisKeyword_14_3());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalEasyWall.g:2284:3: this_EFBuiltinFunction_38= ruleEFBuiltinFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getEFBuiltinFunctionParserRuleCall_15());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EFBuiltinFunction_38=ruleEFBuiltinFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EFBuiltinFunction_38;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalEasyWall.g:2293:3: ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' )
                    {
                    // InternalEasyWall.g:2293:3: ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' )
                    // InternalEasyWall.g:2294:4: () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')'
                    {
                    // InternalEasyWall.g:2294:4: ()
                    // InternalEasyWall.g:2295:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFFunctionCallAction_16_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2301:4: ( (lv_functionName_40_0= ruleQualifiedName ) )
                    // InternalEasyWall.g:2302:5: (lv_functionName_40_0= ruleQualifiedName )
                    {
                    // InternalEasyWall.g:2302:5: (lv_functionName_40_0= ruleQualifiedName )
                    // InternalEasyWall.g:2303:6: lv_functionName_40_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getFunctionNameQualifiedNameParserRuleCall_16_1_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_functionName_40_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"functionName",
                      							lv_functionName_40_0,
                      							"org.xtext.example.easywall.EasyWall.QualifiedName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_41=(Token)match(input,28,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_41, grammarAccess.getEFPrimaryExpressionAccess().getLeftParenthesisKeyword_16_2());
                      			
                    }
                    // InternalEasyWall.g:2324:4: ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_EFIPV4SYNTAX)||LA34_0==26||LA34_0==28||(LA34_0>=36 && LA34_0<=47)||(LA34_0>=54 && LA34_0<=55)||(LA34_0>=78 && LA34_0<=80)||(LA34_0>=89 && LA34_0<=113)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalEasyWall.g:2325:5: ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )*
                            {
                            // InternalEasyWall.g:2325:5: ( (lv_args_42_0= ruleEFExpression ) )
                            // InternalEasyWall.g:2326:6: (lv_args_42_0= ruleEFExpression )
                            {
                            // InternalEasyWall.g:2326:6: (lv_args_42_0= ruleEFExpression )
                            // InternalEasyWall.g:2327:7: lv_args_42_0= ruleEFExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getArgsEFExpressionParserRuleCall_16_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_21);
                            lv_args_42_0=ruleEFExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_42_0,
                              								"org.xtext.example.easywall.EasyWall.EFExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalEasyWall.g:2344:5: (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==29) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalEasyWall.g:2345:6: otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) )
                            	    {
                            	    otherlv_43=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_43, grammarAccess.getEFPrimaryExpressionAccess().getCommaKeyword_16_3_1_0());
                            	      					
                            	    }
                            	    // InternalEasyWall.g:2349:6: ( (lv_args_44_0= ruleEFExpression ) )
                            	    // InternalEasyWall.g:2350:7: (lv_args_44_0= ruleEFExpression )
                            	    {
                            	    // InternalEasyWall.g:2350:7: (lv_args_44_0= ruleEFExpression )
                            	    // InternalEasyWall.g:2351:8: lv_args_44_0= ruleEFExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getArgsEFExpressionParserRuleCall_16_3_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_21);
                            	    lv_args_44_0=ruleEFExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getEFPrimaryExpressionRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_44_0,
                            	      									"org.xtext.example.easywall.EasyWall.EFExpression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_45=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_45, grammarAccess.getEFPrimaryExpressionAccess().getRightParenthesisKeyword_16_4());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalEasyWall.g:2376:3: ( () ( ( ruleQualifiedName ) ) )
                    {
                    // InternalEasyWall.g:2376:3: ( () ( ( ruleQualifiedName ) ) )
                    // InternalEasyWall.g:2377:4: () ( ( ruleQualifiedName ) )
                    {
                    // InternalEasyWall.g:2377:4: ()
                    // InternalEasyWall.g:2378:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFPrimaryExpressionAccess().getEFSymbolRefAction_17_0(),
                      						current);
                      				
                    }

                    }

                    // InternalEasyWall.g:2384:4: ( ( ruleQualifiedName ) )
                    // InternalEasyWall.g:2385:5: ( ruleQualifiedName )
                    {
                    // InternalEasyWall.g:2385:5: ( ruleQualifiedName )
                    // InternalEasyWall.g:2386:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFPrimaryExpressionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFPrimaryExpressionAccess().getSymbolEFFieldCrossReference_17_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFPrimaryExpression"


    // $ANTLR start "entryRuleEFBuiltinFunction"
    // InternalEasyWall.g:2405:1: entryRuleEFBuiltinFunction returns [EObject current=null] : iv_ruleEFBuiltinFunction= ruleEFBuiltinFunction EOF ;
    public final EObject entryRuleEFBuiltinFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFBuiltinFunction = null;


        try {
            // InternalEasyWall.g:2405:58: (iv_ruleEFBuiltinFunction= ruleEFBuiltinFunction EOF )
            // InternalEasyWall.g:2406:2: iv_ruleEFBuiltinFunction= ruleEFBuiltinFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFBuiltinFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFBuiltinFunction=ruleEFBuiltinFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFBuiltinFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFBuiltinFunction"


    // $ANTLR start "ruleEFBuiltinFunction"
    // InternalEasyWall.g:2412:1: ruleEFBuiltinFunction returns [EObject current=null] : ( ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' ) | ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' ) | ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' ) | ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' ) | ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' ) | ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' ) ) ;
    public final EObject ruleEFBuiltinFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token lv_field_27_0=null;
        Token otherlv_28=null;
        EObject lv_message_11_0 = null;

        Enumerator lv_level_16_0 = null;

        EObject lv_message_18_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:2418:2: ( ( ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' ) | ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' ) | ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' ) | ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' ) | ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' ) | ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' ) ) )
            // InternalEasyWall.g:2419:2: ( ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' ) | ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' ) | ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' ) | ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' ) | ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' ) | ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' ) )
            {
            // InternalEasyWall.g:2419:2: ( ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' ) | ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' ) | ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' ) | ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' ) | ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' ) | ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' ) )
            int alt36=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt36=1;
                }
                break;
            case 44:
                {
                alt36=2;
                }
                break;
            case 45:
                {
                int LA36_3 = input.LA(2);

                if ( (LA36_3==28) ) {
                    int LA36_6 = input.LA(3);

                    if ( ((LA36_6>=81 && LA36_6<=85)) ) {
                        alt36=4;
                    }
                    else if ( ((LA36_6>=RULE_ID && LA36_6<=RULE_EFIPV4SYNTAX)||LA36_6==26||LA36_6==28||(LA36_6>=36 && LA36_6<=47)||(LA36_6>=54 && LA36_6<=55)||(LA36_6>=78 && LA36_6<=80)||(LA36_6>=89 && LA36_6<=113)) ) {
                        alt36=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                alt36=5;
                }
                break;
            case 47:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalEasyWall.g:2420:3: ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' )
                    {
                    // InternalEasyWall.g:2420:3: ( () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')' )
                    // InternalEasyWall.g:2421:4: () otherlv_1= 'allow' otherlv_2= '(' otherlv_3= ')'
                    {
                    // InternalEasyWall.g:2421:4: ()
                    // InternalEasyWall.g:2422:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFAllowAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,43,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEFBuiltinFunctionAccess().getAllowKeyword_0_1());
                      			
                    }
                    otherlv_2=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_0_2());
                      			
                    }
                    otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2442:3: ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' )
                    {
                    // InternalEasyWall.g:2442:3: ( () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')' )
                    // InternalEasyWall.g:2443:4: () otherlv_5= 'deny' otherlv_6= '(' otherlv_7= ')'
                    {
                    // InternalEasyWall.g:2443:4: ()
                    // InternalEasyWall.g:2444:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFDenyAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,44,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEFBuiltinFunctionAccess().getDenyKeyword_1_1());
                      			
                    }
                    otherlv_6=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_1_2());
                      			
                    }
                    otherlv_7=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_1_3());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:2464:3: ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' )
                    {
                    // InternalEasyWall.g:2464:3: ( () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')' )
                    // InternalEasyWall.g:2465:4: () otherlv_9= 'writelog' otherlv_10= '(' ( (lv_message_11_0= ruleEFExpression ) ) otherlv_12= ')'
                    {
                    // InternalEasyWall.g:2465:4: ()
                    // InternalEasyWall.g:2466:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFWriteLogAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,45,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getEFBuiltinFunctionAccess().getWritelogKeyword_2_1());
                      			
                    }
                    otherlv_10=(Token)match(input,28,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_2_2());
                      			
                    }
                    // InternalEasyWall.g:2480:4: ( (lv_message_11_0= ruleEFExpression ) )
                    // InternalEasyWall.g:2481:5: (lv_message_11_0= ruleEFExpression )
                    {
                    // InternalEasyWall.g:2481:5: (lv_message_11_0= ruleEFExpression )
                    // InternalEasyWall.g:2482:6: lv_message_11_0= ruleEFExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFBuiltinFunctionAccess().getMessageEFExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_message_11_0=ruleEFExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFBuiltinFunctionRule());
                      						}
                      						set(
                      							current,
                      							"message",
                      							lv_message_11_0,
                      							"org.xtext.example.easywall.EasyWall.EFExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:2505:3: ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' )
                    {
                    // InternalEasyWall.g:2505:3: ( () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')' )
                    // InternalEasyWall.g:2506:4: () otherlv_14= 'writelog' otherlv_15= '(' ( (lv_level_16_0= ruleEFLogLevel ) ) otherlv_17= ',' ( (lv_message_18_0= ruleEFExpression ) ) otherlv_19= ')'
                    {
                    // InternalEasyWall.g:2506:4: ()
                    // InternalEasyWall.g:2507:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFWriteLogLevelAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_14=(Token)match(input,45,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getEFBuiltinFunctionAccess().getWritelogKeyword_3_1());
                      			
                    }
                    otherlv_15=(Token)match(input,28,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_3_2());
                      			
                    }
                    // InternalEasyWall.g:2521:4: ( (lv_level_16_0= ruleEFLogLevel ) )
                    // InternalEasyWall.g:2522:5: (lv_level_16_0= ruleEFLogLevel )
                    {
                    // InternalEasyWall.g:2522:5: (lv_level_16_0= ruleEFLogLevel )
                    // InternalEasyWall.g:2523:6: lv_level_16_0= ruleEFLogLevel
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFBuiltinFunctionAccess().getLevelEFLogLevelEnumRuleCall_3_3_0());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_level_16_0=ruleEFLogLevel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFBuiltinFunctionRule());
                      						}
                      						set(
                      							current,
                      							"level",
                      							lv_level_16_0,
                      							"org.xtext.example.easywall.EasyWall.EFLogLevel");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_17=(Token)match(input,29,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getEFBuiltinFunctionAccess().getCommaKeyword_3_4());
                      			
                    }
                    // InternalEasyWall.g:2544:4: ( (lv_message_18_0= ruleEFExpression ) )
                    // InternalEasyWall.g:2545:5: (lv_message_18_0= ruleEFExpression )
                    {
                    // InternalEasyWall.g:2545:5: (lv_message_18_0= ruleEFExpression )
                    // InternalEasyWall.g:2546:6: lv_message_18_0= ruleEFExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEFBuiltinFunctionAccess().getMessageEFExpressionParserRuleCall_3_5_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_message_18_0=ruleEFExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEFBuiltinFunctionRule());
                      						}
                      						set(
                      							current,
                      							"message",
                      							lv_message_18_0,
                      							"org.xtext.example.easywall.EasyWall.EFExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_3_6());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:2569:3: ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' )
                    {
                    // InternalEasyWall.g:2569:3: ( () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')' )
                    // InternalEasyWall.g:2570:4: () otherlv_21= 'getTime' otherlv_22= '(' otherlv_23= ')'
                    {
                    // InternalEasyWall.g:2570:4: ()
                    // InternalEasyWall.g:2571:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFGetTimeAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_21=(Token)match(input,46,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getEFBuiltinFunctionAccess().getGetTimeKeyword_4_1());
                      			
                    }
                    otherlv_22=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_22, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_4_2());
                      			
                    }
                    otherlv_23=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalEasyWall.g:2591:3: ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' )
                    {
                    // InternalEasyWall.g:2591:3: ( () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')' )
                    // InternalEasyWall.g:2592:4: () otherlv_25= 'getPacketField' otherlv_26= '(' ( (lv_field_27_0= RULE_STRING ) ) otherlv_28= ')'
                    {
                    // InternalEasyWall.g:2592:4: ()
                    // InternalEasyWall.g:2593:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getEFBuiltinFunctionAccess().getEFGetPacketFieldAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_25=(Token)match(input,47,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_25, grammarAccess.getEFBuiltinFunctionAccess().getGetPacketFieldKeyword_5_1());
                      			
                    }
                    otherlv_26=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_26, grammarAccess.getEFBuiltinFunctionAccess().getLeftParenthesisKeyword_5_2());
                      			
                    }
                    // InternalEasyWall.g:2607:4: ( (lv_field_27_0= RULE_STRING ) )
                    // InternalEasyWall.g:2608:5: (lv_field_27_0= RULE_STRING )
                    {
                    // InternalEasyWall.g:2608:5: (lv_field_27_0= RULE_STRING )
                    // InternalEasyWall.g:2609:6: lv_field_27_0= RULE_STRING
                    {
                    lv_field_27_0=(Token)match(input,RULE_STRING,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_field_27_0, grammarAccess.getEFBuiltinFunctionAccess().getFieldSTRINGTerminalRuleCall_5_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEFBuiltinFunctionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"field",
                      							lv_field_27_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }

                    otherlv_28=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_28, grammarAccess.getEFBuiltinFunctionAccess().getRightParenthesisKeyword_5_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFBuiltinFunction"


    // $ANTLR start "entryRuleEFRule"
    // InternalEasyWall.g:2634:1: entryRuleEFRule returns [EObject current=null] : iv_ruleEFRule= ruleEFRule EOF ;
    public final EObject entryRuleEFRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFRule = null;


        try {
            // InternalEasyWall.g:2634:47: (iv_ruleEFRule= ruleEFRule EOF )
            // InternalEasyWall.g:2635:2: iv_ruleEFRule= ruleEFRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFRule=ruleEFRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFRule"


    // $ANTLR start "ruleEFRule"
    // InternalEasyWall.g:2641:1: ruleEFRule returns [EObject current=null] : ( (lv_rules_0_0= ruleEFRuleClass ) ) ;
    public final EObject ruleEFRule() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:2647:2: ( ( (lv_rules_0_0= ruleEFRuleClass ) ) )
            // InternalEasyWall.g:2648:2: ( (lv_rules_0_0= ruleEFRuleClass ) )
            {
            // InternalEasyWall.g:2648:2: ( (lv_rules_0_0= ruleEFRuleClass ) )
            // InternalEasyWall.g:2649:3: (lv_rules_0_0= ruleEFRuleClass )
            {
            // InternalEasyWall.g:2649:3: (lv_rules_0_0= ruleEFRuleClass )
            // InternalEasyWall.g:2650:4: lv_rules_0_0= ruleEFRuleClass
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getEFRuleAccess().getRulesEFRuleClassParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_rules_0_0=ruleEFRuleClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getEFRuleRule());
              				}
              				set(
              					current,
              					"rules",
              					lv_rules_0_0,
              					"org.xtext.example.easywall.EasyWall.EFRuleClass");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRule"


    // $ANTLR start "entryRuleEFRuleClass"
    // InternalEasyWall.g:2670:1: entryRuleEFRuleClass returns [EObject current=null] : iv_ruleEFRuleClass= ruleEFRuleClass EOF ;
    public final EObject entryRuleEFRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFRuleClass = null;


        try {
            // InternalEasyWall.g:2670:52: (iv_ruleEFRuleClass= ruleEFRuleClass EOF )
            // InternalEasyWall.g:2671:2: iv_ruleEFRuleClass= ruleEFRuleClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFRuleClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFRuleClass=ruleEFRuleClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFRuleClass; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFRuleClass"


    // $ANTLR start "ruleEFRuleClass"
    // InternalEasyWall.g:2677:1: ruleEFRuleClass returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'at' ( (lv_type_3_0= ruleEFRulesTypes ) ) otherlv_4= '{' ( (lv_members_5_0= ruleEFMember ) )* otherlv_6= '}' ) ;
    public final EObject ruleEFRuleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_members_5_0 = null;



        	enterRule();

        try {
            // InternalEasyWall.g:2683:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'at' ( (lv_type_3_0= ruleEFRulesTypes ) ) otherlv_4= '{' ( (lv_members_5_0= ruleEFMember ) )* otherlv_6= '}' ) )
            // InternalEasyWall.g:2684:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'at' ( (lv_type_3_0= ruleEFRulesTypes ) ) otherlv_4= '{' ( (lv_members_5_0= ruleEFMember ) )* otherlv_6= '}' )
            {
            // InternalEasyWall.g:2684:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'at' ( (lv_type_3_0= ruleEFRulesTypes ) ) otherlv_4= '{' ( (lv_members_5_0= ruleEFMember ) )* otherlv_6= '}' )
            // InternalEasyWall.g:2685:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'at' ( (lv_type_3_0= ruleEFRulesTypes ) ) otherlv_4= '{' ( (lv_members_5_0= ruleEFMember ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEFRuleClassAccess().getRuleKeyword_0());
              		
            }
            // InternalEasyWall.g:2689:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalEasyWall.g:2690:4: (lv_name_1_0= RULE_ID )
            {
            // InternalEasyWall.g:2690:4: (lv_name_1_0= RULE_ID )
            // InternalEasyWall.g:2691:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEFRuleClassAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFRuleClassRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEFRuleClassAccess().getAtKeyword_2());
              		
            }
            // InternalEasyWall.g:2711:3: ( (lv_type_3_0= ruleEFRulesTypes ) )
            // InternalEasyWall.g:2712:4: (lv_type_3_0= ruleEFRulesTypes )
            {
            // InternalEasyWall.g:2712:4: (lv_type_3_0= ruleEFRulesTypes )
            // InternalEasyWall.g:2713:5: lv_type_3_0= ruleEFRulesTypes
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEFRuleClassAccess().getTypeEFRulesTypesEnumRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_type_3_0=ruleEFRulesTypes();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEFRuleClassRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.xtext.example.easywall.EasyWall.EFRulesTypes");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEFRuleClassAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalEasyWall.g:2734:3: ( (lv_members_5_0= ruleEFMember ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=23 && LA37_0<=24)||LA37_0==27) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalEasyWall.g:2735:4: (lv_members_5_0= ruleEFMember )
            	    {
            	    // InternalEasyWall.g:2735:4: (lv_members_5_0= ruleEFMember )
            	    // InternalEasyWall.g:2736:5: lv_members_5_0= ruleEFMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEFRuleClassAccess().getMembersEFMemberParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_members_5_0=ruleEFMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEFRuleClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"members",
            	      						lv_members_5_0,
            	      						"org.xtext.example.easywall.EasyWall.EFMember");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEFRuleClassAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRuleClass"


    // $ANTLR start "entryRuleEFOr"
    // InternalEasyWall.g:2761:1: entryRuleEFOr returns [String current=null] : iv_ruleEFOr= ruleEFOr EOF ;
    public final String entryRuleEFOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFOr = null;


        try {
            // InternalEasyWall.g:2761:44: (iv_ruleEFOr= ruleEFOr EOF )
            // InternalEasyWall.g:2762:2: iv_ruleEFOr= ruleEFOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFOr=ruleEFOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFOr"


    // $ANTLR start "ruleEFOr"
    // InternalEasyWall.g:2768:1: ruleEFOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '||' | kw= 'or' ) ;
    public final AntlrDatatypeRuleToken ruleEFOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2774:2: ( (kw= '||' | kw= 'or' ) )
            // InternalEasyWall.g:2775:2: (kw= '||' | kw= 'or' )
            {
            // InternalEasyWall.g:2775:2: (kw= '||' | kw= 'or' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==50) ) {
                alt38=1;
            }
            else if ( (LA38_0==51) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalEasyWall.g:2776:3: kw= '||'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFOrAccess().getVerticalLineVerticalLineKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2782:3: kw= 'or'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFOrAccess().getOrKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFOr"


    // $ANTLR start "entryRuleEFAnd"
    // InternalEasyWall.g:2791:1: entryRuleEFAnd returns [String current=null] : iv_ruleEFAnd= ruleEFAnd EOF ;
    public final String entryRuleEFAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFAnd = null;


        try {
            // InternalEasyWall.g:2791:45: (iv_ruleEFAnd= ruleEFAnd EOF )
            // InternalEasyWall.g:2792:2: iv_ruleEFAnd= ruleEFAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFAnd=ruleEFAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFAnd"


    // $ANTLR start "ruleEFAnd"
    // InternalEasyWall.g:2798:1: ruleEFAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '&&' | kw= 'and' ) ;
    public final AntlrDatatypeRuleToken ruleEFAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2804:2: ( (kw= '&&' | kw= 'and' ) )
            // InternalEasyWall.g:2805:2: (kw= '&&' | kw= 'and' )
            {
            // InternalEasyWall.g:2805:2: (kw= '&&' | kw= 'and' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) ) {
                alt39=1;
            }
            else if ( (LA39_0==53) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalEasyWall.g:2806:3: kw= '&&'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFAndAccess().getAmpersandAmpersandKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2812:3: kw= 'and'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFAndAccess().getAndKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFAnd"


    // $ANTLR start "entryRuleEFNot"
    // InternalEasyWall.g:2821:1: entryRuleEFNot returns [String current=null] : iv_ruleEFNot= ruleEFNot EOF ;
    public final String entryRuleEFNot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFNot = null;


        try {
            // InternalEasyWall.g:2821:45: (iv_ruleEFNot= ruleEFNot EOF )
            // InternalEasyWall.g:2822:2: iv_ruleEFNot= ruleEFNot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFNotRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFNot=ruleEFNot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFNot.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFNot"


    // $ANTLR start "ruleEFNot"
    // InternalEasyWall.g:2828:1: ruleEFNot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEFNot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2834:2: ( (kw= '!' | kw= 'not' ) )
            // InternalEasyWall.g:2835:2: (kw= '!' | kw= 'not' )
            {
            // InternalEasyWall.g:2835:2: (kw= '!' | kw= 'not' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==54) ) {
                alt40=1;
            }
            else if ( (LA40_0==55) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalEasyWall.g:2836:3: kw= '!'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFNotAccess().getExclamationMarkKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2842:3: kw= 'not'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFNotAccess().getNotKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFNot"


    // $ANTLR start "entryRuleEFEqualOperators"
    // InternalEasyWall.g:2851:1: entryRuleEFEqualOperators returns [String current=null] : iv_ruleEFEqualOperators= ruleEFEqualOperators EOF ;
    public final String entryRuleEFEqualOperators() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFEqualOperators = null;


        try {
            // InternalEasyWall.g:2851:56: (iv_ruleEFEqualOperators= ruleEFEqualOperators EOF )
            // InternalEasyWall.g:2852:2: iv_ruleEFEqualOperators= ruleEFEqualOperators EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFEqualOperatorsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFEqualOperators=ruleEFEqualOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFEqualOperators.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFEqualOperators"


    // $ANTLR start "ruleEFEqualOperators"
    // InternalEasyWall.g:2858:1: ruleEFEqualOperators returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= 'isequalto' ) ;
    public final AntlrDatatypeRuleToken ruleEFEqualOperators() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2864:2: ( (kw= '==' | kw= '!=' | kw= 'isequalto' ) )
            // InternalEasyWall.g:2865:2: (kw= '==' | kw= '!=' | kw= 'isequalto' )
            {
            // InternalEasyWall.g:2865:2: (kw= '==' | kw= '!=' | kw= 'isequalto' )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt41=1;
                }
                break;
            case 57:
                {
                alt41=2;
                }
                break;
            case 58:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalEasyWall.g:2866:3: kw= '=='
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFEqualOperatorsAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2872:3: kw= '!='
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFEqualOperatorsAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:2878:3: kw= 'isequalto'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFEqualOperatorsAccess().getIsequaltoKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFEqualOperators"


    // $ANTLR start "entryRuleEFRelOperators"
    // InternalEasyWall.g:2887:1: entryRuleEFRelOperators returns [String current=null] : iv_ruleEFRelOperators= ruleEFRelOperators EOF ;
    public final String entryRuleEFRelOperators() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFRelOperators = null;


        try {
            // InternalEasyWall.g:2887:54: (iv_ruleEFRelOperators= ruleEFRelOperators EOF )
            // InternalEasyWall.g:2888:2: iv_ruleEFRelOperators= ruleEFRelOperators EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFRelOperatorsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFRelOperators=ruleEFRelOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFRelOperators.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFRelOperators"


    // $ANTLR start "ruleEFRelOperators"
    // InternalEasyWall.g:2894:1: ruleEFRelOperators returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleEFRelOperators() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2900:2: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // InternalEasyWall.g:2901:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // InternalEasyWall.g:2901:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt42=1;
                }
                break;
            case 60:
                {
                alt42=2;
                }
                break;
            case 61:
                {
                alt42=3;
                }
                break;
            case 62:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalEasyWall.g:2902:3: kw= '>='
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFRelOperatorsAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2908:3: kw= '<='
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFRelOperatorsAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:2914:3: kw= '>'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFRelOperatorsAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:2920:3: kw= '<'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFRelOperatorsAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRelOperators"


    // $ANTLR start "entryRuleEFAddOperators"
    // InternalEasyWall.g:2929:1: entryRuleEFAddOperators returns [String current=null] : iv_ruleEFAddOperators= ruleEFAddOperators EOF ;
    public final String entryRuleEFAddOperators() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFAddOperators = null;


        try {
            // InternalEasyWall.g:2929:54: (iv_ruleEFAddOperators= ruleEFAddOperators EOF )
            // InternalEasyWall.g:2930:2: iv_ruleEFAddOperators= ruleEFAddOperators EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFAddOperatorsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFAddOperators=ruleEFAddOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFAddOperators.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFAddOperators"


    // $ANTLR start "ruleEFAddOperators"
    // InternalEasyWall.g:2936:1: ruleEFAddOperators returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleEFAddOperators() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2942:2: ( (kw= '+' | kw= '-' ) )
            // InternalEasyWall.g:2943:2: (kw= '+' | kw= '-' )
            {
            // InternalEasyWall.g:2943:2: (kw= '+' | kw= '-' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==63) ) {
                alt43=1;
            }
            else if ( (LA43_0==64) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalEasyWall.g:2944:3: kw= '+'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFAddOperatorsAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2950:3: kw= '-'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFAddOperatorsAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFAddOperators"


    // $ANTLR start "entryRuleEFMultOperators"
    // InternalEasyWall.g:2959:1: entryRuleEFMultOperators returns [String current=null] : iv_ruleEFMultOperators= ruleEFMultOperators EOF ;
    public final String entryRuleEFMultOperators() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFMultOperators = null;


        try {
            // InternalEasyWall.g:2959:55: (iv_ruleEFMultOperators= ruleEFMultOperators EOF )
            // InternalEasyWall.g:2960:2: iv_ruleEFMultOperators= ruleEFMultOperators EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFMultOperatorsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFMultOperators=ruleEFMultOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFMultOperators.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFMultOperators"


    // $ANTLR start "ruleEFMultOperators"
    // InternalEasyWall.g:2966:1: ruleEFMultOperators returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= 'div' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleEFMultOperators() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalEasyWall.g:2972:2: ( (kw= '*' | kw= 'div' | kw= '%' ) )
            // InternalEasyWall.g:2973:2: (kw= '*' | kw= 'div' | kw= '%' )
            {
            // InternalEasyWall.g:2973:2: (kw= '*' | kw= 'div' | kw= '%' )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt44=1;
                }
                break;
            case 66:
                {
                alt44=2;
                }
                break;
            case 67:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalEasyWall.g:2974:3: kw= '*'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFMultOperatorsAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:2980:3: kw= 'div'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFMultOperatorsAccess().getDivKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:2986:3: kw= '%'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEFMultOperatorsAccess().getPercentSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFMultOperators"


    // $ANTLR start "entryRuleEFNetworkSYNTAX"
    // InternalEasyWall.g:2995:1: entryRuleEFNetworkSYNTAX returns [EObject current=null] : iv_ruleEFNetworkSYNTAX= ruleEFNetworkSYNTAX EOF ;
    public final EObject entryRuleEFNetworkSYNTAX() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEFNetworkSYNTAX = null;


        try {
            // InternalEasyWall.g:2995:56: (iv_ruleEFNetworkSYNTAX= ruleEFNetworkSYNTAX EOF )
            // InternalEasyWall.g:2996:2: iv_ruleEFNetworkSYNTAX= ruleEFNetworkSYNTAX EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEFNetworkSYNTAXRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEFNetworkSYNTAX=ruleEFNetworkSYNTAX();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEFNetworkSYNTAX; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFNetworkSYNTAX"


    // $ANTLR start "ruleEFNetworkSYNTAX"
    // InternalEasyWall.g:3002:1: ruleEFNetworkSYNTAX returns [EObject current=null] : ( ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) ) otherlv_1= '/' ( (lv_rawnetmask_2_0= RULE_INT ) ) ) ;
    public final EObject ruleEFNetworkSYNTAX() throws RecognitionException {
        EObject current = null;

        Token lv_rawip_0_0=null;
        Token otherlv_1=null;
        Token lv_rawnetmask_2_0=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3008:2: ( ( ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) ) otherlv_1= '/' ( (lv_rawnetmask_2_0= RULE_INT ) ) ) )
            // InternalEasyWall.g:3009:2: ( ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) ) otherlv_1= '/' ( (lv_rawnetmask_2_0= RULE_INT ) ) )
            {
            // InternalEasyWall.g:3009:2: ( ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) ) otherlv_1= '/' ( (lv_rawnetmask_2_0= RULE_INT ) ) )
            // InternalEasyWall.g:3010:3: ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) ) otherlv_1= '/' ( (lv_rawnetmask_2_0= RULE_INT ) )
            {
            // InternalEasyWall.g:3010:3: ( (lv_rawip_0_0= RULE_EFIPV4SYNTAX ) )
            // InternalEasyWall.g:3011:4: (lv_rawip_0_0= RULE_EFIPV4SYNTAX )
            {
            // InternalEasyWall.g:3011:4: (lv_rawip_0_0= RULE_EFIPV4SYNTAX )
            // InternalEasyWall.g:3012:5: lv_rawip_0_0= RULE_EFIPV4SYNTAX
            {
            lv_rawip_0_0=(Token)match(input,RULE_EFIPV4SYNTAX,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_rawip_0_0, grammarAccess.getEFNetworkSYNTAXAccess().getRawipEFIPV4SYNTAXTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFNetworkSYNTAXRule());
              					}
              					setWithLastConsumed(
              						current,
              						"rawip",
              						lv_rawip_0_0,
              						"org.xtext.example.easywall.EasyWall.EFIPV4SYNTAX");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEFNetworkSYNTAXAccess().getSolidusKeyword_1());
              		
            }
            // InternalEasyWall.g:3032:3: ( (lv_rawnetmask_2_0= RULE_INT ) )
            // InternalEasyWall.g:3033:4: (lv_rawnetmask_2_0= RULE_INT )
            {
            // InternalEasyWall.g:3033:4: (lv_rawnetmask_2_0= RULE_INT )
            // InternalEasyWall.g:3034:5: lv_rawnetmask_2_0= RULE_INT
            {
            lv_rawnetmask_2_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_rawnetmask_2_0, grammarAccess.getEFNetworkSYNTAXAccess().getRawnetmaskINTTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEFNetworkSYNTAXRule());
              					}
              					setWithLastConsumed(
              						current,
              						"rawnetmask",
              						lv_rawnetmask_2_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFNetworkSYNTAX"


    // $ANTLR start "ruleEFDefaultAction"
    // InternalEasyWall.g:3054:1: ruleEFDefaultAction returns [Enumerator current=null] : ( (enumLiteral_0= 'allow' ) | (enumLiteral_1= 'deny' ) ) ;
    public final Enumerator ruleEFDefaultAction() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3060:2: ( ( (enumLiteral_0= 'allow' ) | (enumLiteral_1= 'deny' ) ) )
            // InternalEasyWall.g:3061:2: ( (enumLiteral_0= 'allow' ) | (enumLiteral_1= 'deny' ) )
            {
            // InternalEasyWall.g:3061:2: ( (enumLiteral_0= 'allow' ) | (enumLiteral_1= 'deny' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                alt45=1;
            }
            else if ( (LA45_0==44) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalEasyWall.g:3062:3: (enumLiteral_0= 'allow' )
                    {
                    // InternalEasyWall.g:3062:3: (enumLiteral_0= 'allow' )
                    // InternalEasyWall.g:3063:4: enumLiteral_0= 'allow'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFDefaultActionAccess().getALLOWEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEFDefaultActionAccess().getALLOWEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3070:3: (enumLiteral_1= 'deny' )
                    {
                    // InternalEasyWall.g:3070:3: (enumLiteral_1= 'deny' )
                    // InternalEasyWall.g:3071:4: enumLiteral_1= 'deny'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFDefaultActionAccess().getDENYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEFDefaultActionAccess().getDENYEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFDefaultAction"


    // $ANTLR start "ruleEFType"
    // InternalEasyWall.g:3081:1: ruleEFType returns [Enumerator current=null] : ( (enumLiteral_0= 'network' ) | (enumLiteral_1= 'netip' ) | (enumLiteral_2= 'netipv6' ) | (enumLiteral_3= 'netport' ) | (enumLiteral_4= 'protocol' ) | (enumLiteral_5= 'direction' ) | (enumLiteral_6= 'int' ) | (enumLiteral_7= 'string' ) | (enumLiteral_8= 'bool' ) ) ;
    public final Enumerator ruleEFType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3087:2: ( ( (enumLiteral_0= 'network' ) | (enumLiteral_1= 'netip' ) | (enumLiteral_2= 'netipv6' ) | (enumLiteral_3= 'netport' ) | (enumLiteral_4= 'protocol' ) | (enumLiteral_5= 'direction' ) | (enumLiteral_6= 'int' ) | (enumLiteral_7= 'string' ) | (enumLiteral_8= 'bool' ) ) )
            // InternalEasyWall.g:3088:2: ( (enumLiteral_0= 'network' ) | (enumLiteral_1= 'netip' ) | (enumLiteral_2= 'netipv6' ) | (enumLiteral_3= 'netport' ) | (enumLiteral_4= 'protocol' ) | (enumLiteral_5= 'direction' ) | (enumLiteral_6= 'int' ) | (enumLiteral_7= 'string' ) | (enumLiteral_8= 'bool' ) )
            {
            // InternalEasyWall.g:3088:2: ( (enumLiteral_0= 'network' ) | (enumLiteral_1= 'netip' ) | (enumLiteral_2= 'netipv6' ) | (enumLiteral_3= 'netport' ) | (enumLiteral_4= 'protocol' ) | (enumLiteral_5= 'direction' ) | (enumLiteral_6= 'int' ) | (enumLiteral_7= 'string' ) | (enumLiteral_8= 'bool' ) )
            int alt46=9;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt46=1;
                }
                break;
            case 70:
                {
                alt46=2;
                }
                break;
            case 71:
                {
                alt46=3;
                }
                break;
            case 72:
                {
                alt46=4;
                }
                break;
            case 73:
                {
                alt46=5;
                }
                break;
            case 74:
                {
                alt46=6;
                }
                break;
            case 75:
                {
                alt46=7;
                }
                break;
            case 76:
                {
                alt46=8;
                }
                break;
            case 77:
                {
                alt46=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalEasyWall.g:3089:3: (enumLiteral_0= 'network' )
                    {
                    // InternalEasyWall.g:3089:3: (enumLiteral_0= 'network' )
                    // InternalEasyWall.g:3090:4: enumLiteral_0= 'network'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getNETWORKEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEFTypeAccess().getNETWORKEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3097:3: (enumLiteral_1= 'netip' )
                    {
                    // InternalEasyWall.g:3097:3: (enumLiteral_1= 'netip' )
                    // InternalEasyWall.g:3098:4: enumLiteral_1= 'netip'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getIPv4EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEFTypeAccess().getIPv4EnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3105:3: (enumLiteral_2= 'netipv6' )
                    {
                    // InternalEasyWall.g:3105:3: (enumLiteral_2= 'netipv6' )
                    // InternalEasyWall.g:3106:4: enumLiteral_2= 'netipv6'
                    {
                    enumLiteral_2=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getIPv6EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getEFTypeAccess().getIPv6EnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:3113:3: (enumLiteral_3= 'netport' )
                    {
                    // InternalEasyWall.g:3113:3: (enumLiteral_3= 'netport' )
                    // InternalEasyWall.g:3114:4: enumLiteral_3= 'netport'
                    {
                    enumLiteral_3=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getPORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getEFTypeAccess().getPORTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:3121:3: (enumLiteral_4= 'protocol' )
                    {
                    // InternalEasyWall.g:3121:3: (enumLiteral_4= 'protocol' )
                    // InternalEasyWall.g:3122:4: enumLiteral_4= 'protocol'
                    {
                    enumLiteral_4=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getPROTOCOLEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getEFTypeAccess().getPROTOCOLEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalEasyWall.g:3129:3: (enumLiteral_5= 'direction' )
                    {
                    // InternalEasyWall.g:3129:3: (enumLiteral_5= 'direction' )
                    // InternalEasyWall.g:3130:4: enumLiteral_5= 'direction'
                    {
                    enumLiteral_5=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getDIRECTIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getEFTypeAccess().getDIRECTIONEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalEasyWall.g:3137:3: (enumLiteral_6= 'int' )
                    {
                    // InternalEasyWall.g:3137:3: (enumLiteral_6= 'int' )
                    // InternalEasyWall.g:3138:4: enumLiteral_6= 'int'
                    {
                    enumLiteral_6=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getINTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getEFTypeAccess().getINTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalEasyWall.g:3145:3: (enumLiteral_7= 'string' )
                    {
                    // InternalEasyWall.g:3145:3: (enumLiteral_7= 'string' )
                    // InternalEasyWall.g:3146:4: enumLiteral_7= 'string'
                    {
                    enumLiteral_7=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getSTRINGEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getEFTypeAccess().getSTRINGEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalEasyWall.g:3153:3: (enumLiteral_8= 'bool' )
                    {
                    // InternalEasyWall.g:3153:3: (enumLiteral_8= 'bool' )
                    // InternalEasyWall.g:3154:4: enumLiteral_8= 'bool'
                    {
                    enumLiteral_8=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFTypeAccess().getBOOLEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getEFTypeAccess().getBOOLEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFType"


    // $ANTLR start "ruleEFDirectionNativeType"
    // InternalEasyWall.g:3164:1: ruleEFDirectionNativeType returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'forward' ) ) ;
    public final Enumerator ruleEFDirectionNativeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3170:2: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'forward' ) ) )
            // InternalEasyWall.g:3171:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'forward' ) )
            {
            // InternalEasyWall.g:3171:2: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'forward' ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt47=1;
                }
                break;
            case 79:
                {
                alt47=2;
                }
                break;
            case 80:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalEasyWall.g:3172:3: (enumLiteral_0= 'in' )
                    {
                    // InternalEasyWall.g:3172:3: (enumLiteral_0= 'in' )
                    // InternalEasyWall.g:3173:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFDirectionNativeTypeAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEFDirectionNativeTypeAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3180:3: (enumLiteral_1= 'out' )
                    {
                    // InternalEasyWall.g:3180:3: (enumLiteral_1= 'out' )
                    // InternalEasyWall.g:3181:4: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFDirectionNativeTypeAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEFDirectionNativeTypeAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3188:3: (enumLiteral_2= 'forward' )
                    {
                    // InternalEasyWall.g:3188:3: (enumLiteral_2= 'forward' )
                    // InternalEasyWall.g:3189:4: enumLiteral_2= 'forward'
                    {
                    enumLiteral_2=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFDirectionNativeTypeAccess().getFORWARDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getEFDirectionNativeTypeAccess().getFORWARDEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFDirectionNativeType"


    // $ANTLR start "ruleEFLogLevel"
    // InternalEasyWall.g:3199:1: ruleEFLogLevel returns [Enumerator current=null] : ( (enumLiteral_0= 'debug' ) | (enumLiteral_1= 'info' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'error' ) | (enumLiteral_4= 'critical' ) ) ;
    public final Enumerator ruleEFLogLevel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3205:2: ( ( (enumLiteral_0= 'debug' ) | (enumLiteral_1= 'info' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'error' ) | (enumLiteral_4= 'critical' ) ) )
            // InternalEasyWall.g:3206:2: ( (enumLiteral_0= 'debug' ) | (enumLiteral_1= 'info' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'error' ) | (enumLiteral_4= 'critical' ) )
            {
            // InternalEasyWall.g:3206:2: ( (enumLiteral_0= 'debug' ) | (enumLiteral_1= 'info' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'error' ) | (enumLiteral_4= 'critical' ) )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt48=1;
                }
                break;
            case 82:
                {
                alt48=2;
                }
                break;
            case 83:
                {
                alt48=3;
                }
                break;
            case 84:
                {
                alt48=4;
                }
                break;
            case 85:
                {
                alt48=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalEasyWall.g:3207:3: (enumLiteral_0= 'debug' )
                    {
                    // InternalEasyWall.g:3207:3: (enumLiteral_0= 'debug' )
                    // InternalEasyWall.g:3208:4: enumLiteral_0= 'debug'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFLogLevelAccess().getDEBUGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEFLogLevelAccess().getDEBUGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3215:3: (enumLiteral_1= 'info' )
                    {
                    // InternalEasyWall.g:3215:3: (enumLiteral_1= 'info' )
                    // InternalEasyWall.g:3216:4: enumLiteral_1= 'info'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFLogLevelAccess().getINFOEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEFLogLevelAccess().getINFOEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3223:3: (enumLiteral_2= 'warning' )
                    {
                    // InternalEasyWall.g:3223:3: (enumLiteral_2= 'warning' )
                    // InternalEasyWall.g:3224:4: enumLiteral_2= 'warning'
                    {
                    enumLiteral_2=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFLogLevelAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getEFLogLevelAccess().getWARNINGEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:3231:3: (enumLiteral_3= 'error' )
                    {
                    // InternalEasyWall.g:3231:3: (enumLiteral_3= 'error' )
                    // InternalEasyWall.g:3232:4: enumLiteral_3= 'error'
                    {
                    enumLiteral_3=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFLogLevelAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getEFLogLevelAccess().getERROREnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:3239:3: (enumLiteral_4= 'critical' )
                    {
                    // InternalEasyWall.g:3239:3: (enumLiteral_4= 'critical' )
                    // InternalEasyWall.g:3240:4: enumLiteral_4= 'critical'
                    {
                    enumLiteral_4=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFLogLevelAccess().getCRITICALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getEFLogLevelAccess().getCRITICALEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFLogLevel"


    // $ANTLR start "ruleEFRulesTypes"
    // InternalEasyWall.g:3250:1: ruleEFRulesTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'NetworkLayer' ) | (enumLiteral_1= 'TransportLayer' ) | (enumLiteral_2= 'ApplicationLayer' ) ) ;
    public final Enumerator ruleEFRulesTypes() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3256:2: ( ( (enumLiteral_0= 'NetworkLayer' ) | (enumLiteral_1= 'TransportLayer' ) | (enumLiteral_2= 'ApplicationLayer' ) ) )
            // InternalEasyWall.g:3257:2: ( (enumLiteral_0= 'NetworkLayer' ) | (enumLiteral_1= 'TransportLayer' ) | (enumLiteral_2= 'ApplicationLayer' ) )
            {
            // InternalEasyWall.g:3257:2: ( (enumLiteral_0= 'NetworkLayer' ) | (enumLiteral_1= 'TransportLayer' ) | (enumLiteral_2= 'ApplicationLayer' ) )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt49=1;
                }
                break;
            case 87:
                {
                alt49=2;
                }
                break;
            case 88:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalEasyWall.g:3258:3: (enumLiteral_0= 'NetworkLayer' )
                    {
                    // InternalEasyWall.g:3258:3: (enumLiteral_0= 'NetworkLayer' )
                    // InternalEasyWall.g:3259:4: enumLiteral_0= 'NetworkLayer'
                    {
                    enumLiteral_0=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFRulesTypesAccess().getIPLEVELEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getEFRulesTypesAccess().getIPLEVELEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3266:3: (enumLiteral_1= 'TransportLayer' )
                    {
                    // InternalEasyWall.g:3266:3: (enumLiteral_1= 'TransportLayer' )
                    // InternalEasyWall.g:3267:4: enumLiteral_1= 'TransportLayer'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFRulesTypesAccess().getTRANSPLEVELEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getEFRulesTypesAccess().getTRANSPLEVELEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3274:3: (enumLiteral_2= 'ApplicationLayer' )
                    {
                    // InternalEasyWall.g:3274:3: (enumLiteral_2= 'ApplicationLayer' )
                    // InternalEasyWall.g:3275:4: enumLiteral_2= 'ApplicationLayer'
                    {
                    enumLiteral_2=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getEFRulesTypesAccess().getAPPLEVELEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getEFRulesTypesAccess().getAPPLEVELEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFRulesTypes"


    // $ANTLR start "ruleNETWORKLAYERPROTOCOL"
    // InternalEasyWall.g:3285:1: ruleNETWORKLAYERPROTOCOL returns [Enumerator current=null] : ( (enumLiteral_0= 'IPv4' ) | (enumLiteral_1= 'IPv6' ) | (enumLiteral_2= 'ARP' ) | (enumLiteral_3= 'ICMP' ) | (enumLiteral_4= 'NAT' ) | (enumLiteral_5= 'RIP' ) | (enumLiteral_6= 'OSPF' ) | (enumLiteral_7= 'IPSEC' ) | (enumLiteral_8= 'IGMP' ) ) ;
    public final Enumerator ruleNETWORKLAYERPROTOCOL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3291:2: ( ( (enumLiteral_0= 'IPv4' ) | (enumLiteral_1= 'IPv6' ) | (enumLiteral_2= 'ARP' ) | (enumLiteral_3= 'ICMP' ) | (enumLiteral_4= 'NAT' ) | (enumLiteral_5= 'RIP' ) | (enumLiteral_6= 'OSPF' ) | (enumLiteral_7= 'IPSEC' ) | (enumLiteral_8= 'IGMP' ) ) )
            // InternalEasyWall.g:3292:2: ( (enumLiteral_0= 'IPv4' ) | (enumLiteral_1= 'IPv6' ) | (enumLiteral_2= 'ARP' ) | (enumLiteral_3= 'ICMP' ) | (enumLiteral_4= 'NAT' ) | (enumLiteral_5= 'RIP' ) | (enumLiteral_6= 'OSPF' ) | (enumLiteral_7= 'IPSEC' ) | (enumLiteral_8= 'IGMP' ) )
            {
            // InternalEasyWall.g:3292:2: ( (enumLiteral_0= 'IPv4' ) | (enumLiteral_1= 'IPv6' ) | (enumLiteral_2= 'ARP' ) | (enumLiteral_3= 'ICMP' ) | (enumLiteral_4= 'NAT' ) | (enumLiteral_5= 'RIP' ) | (enumLiteral_6= 'OSPF' ) | (enumLiteral_7= 'IPSEC' ) | (enumLiteral_8= 'IGMP' ) )
            int alt50=9;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt50=1;
                }
                break;
            case 90:
                {
                alt50=2;
                }
                break;
            case 91:
                {
                alt50=3;
                }
                break;
            case 92:
                {
                alt50=4;
                }
                break;
            case 93:
                {
                alt50=5;
                }
                break;
            case 94:
                {
                alt50=6;
                }
                break;
            case 95:
                {
                alt50=7;
                }
                break;
            case 96:
                {
                alt50=8;
                }
                break;
            case 97:
                {
                alt50=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalEasyWall.g:3293:3: (enumLiteral_0= 'IPv4' )
                    {
                    // InternalEasyWall.g:3293:3: (enumLiteral_0= 'IPv4' )
                    // InternalEasyWall.g:3294:4: enumLiteral_0= 'IPv4'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPv4EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPv4EnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3301:3: (enumLiteral_1= 'IPv6' )
                    {
                    // InternalEasyWall.g:3301:3: (enumLiteral_1= 'IPv6' )
                    // InternalEasyWall.g:3302:4: enumLiteral_1= 'IPv6'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPv6EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPv6EnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3309:3: (enumLiteral_2= 'ARP' )
                    {
                    // InternalEasyWall.g:3309:3: (enumLiteral_2= 'ARP' )
                    // InternalEasyWall.g:3310:4: enumLiteral_2= 'ARP'
                    {
                    enumLiteral_2=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getARPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getARPEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:3317:3: (enumLiteral_3= 'ICMP' )
                    {
                    // InternalEasyWall.g:3317:3: (enumLiteral_3= 'ICMP' )
                    // InternalEasyWall.g:3318:4: enumLiteral_3= 'ICMP'
                    {
                    enumLiteral_3=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getICMPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getICMPEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:3325:3: (enumLiteral_4= 'NAT' )
                    {
                    // InternalEasyWall.g:3325:3: (enumLiteral_4= 'NAT' )
                    // InternalEasyWall.g:3326:4: enumLiteral_4= 'NAT'
                    {
                    enumLiteral_4=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getNATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getNATEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalEasyWall.g:3333:3: (enumLiteral_5= 'RIP' )
                    {
                    // InternalEasyWall.g:3333:3: (enumLiteral_5= 'RIP' )
                    // InternalEasyWall.g:3334:4: enumLiteral_5= 'RIP'
                    {
                    enumLiteral_5=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getRIPEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getRIPEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalEasyWall.g:3341:3: (enumLiteral_6= 'OSPF' )
                    {
                    // InternalEasyWall.g:3341:3: (enumLiteral_6= 'OSPF' )
                    // InternalEasyWall.g:3342:4: enumLiteral_6= 'OSPF'
                    {
                    enumLiteral_6=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getOSPFEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getOSPFEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalEasyWall.g:3349:3: (enumLiteral_7= 'IPSEC' )
                    {
                    // InternalEasyWall.g:3349:3: (enumLiteral_7= 'IPSEC' )
                    // InternalEasyWall.g:3350:4: enumLiteral_7= 'IPSEC'
                    {
                    enumLiteral_7=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPSECEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIPSECEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalEasyWall.g:3357:3: (enumLiteral_8= 'IGMP' )
                    {
                    // InternalEasyWall.g:3357:3: (enumLiteral_8= 'IGMP' )
                    // InternalEasyWall.g:3358:4: enumLiteral_8= 'IGMP'
                    {
                    enumLiteral_8=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIGMPEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getNETWORKLAYERPROTOCOLAccess().getIGMPEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNETWORKLAYERPROTOCOL"


    // $ANTLR start "ruleTRANSPORTLAYERPROTOCOL"
    // InternalEasyWall.g:3368:1: ruleTRANSPORTLAYERPROTOCOL returns [Enumerator current=null] : ( (enumLiteral_0= 'UDP' ) | (enumLiteral_1= 'TCP' ) | (enumLiteral_2= 'QUIC' ) | (enumLiteral_3= 'SCTP' ) ) ;
    public final Enumerator ruleTRANSPORTLAYERPROTOCOL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3374:2: ( ( (enumLiteral_0= 'UDP' ) | (enumLiteral_1= 'TCP' ) | (enumLiteral_2= 'QUIC' ) | (enumLiteral_3= 'SCTP' ) ) )
            // InternalEasyWall.g:3375:2: ( (enumLiteral_0= 'UDP' ) | (enumLiteral_1= 'TCP' ) | (enumLiteral_2= 'QUIC' ) | (enumLiteral_3= 'SCTP' ) )
            {
            // InternalEasyWall.g:3375:2: ( (enumLiteral_0= 'UDP' ) | (enumLiteral_1= 'TCP' ) | (enumLiteral_2= 'QUIC' ) | (enumLiteral_3= 'SCTP' ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt51=1;
                }
                break;
            case 99:
                {
                alt51=2;
                }
                break;
            case 100:
                {
                alt51=3;
                }
                break;
            case 101:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalEasyWall.g:3376:3: (enumLiteral_0= 'UDP' )
                    {
                    // InternalEasyWall.g:3376:3: (enumLiteral_0= 'UDP' )
                    // InternalEasyWall.g:3377:4: enumLiteral_0= 'UDP'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getUDPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getUDPEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3384:3: (enumLiteral_1= 'TCP' )
                    {
                    // InternalEasyWall.g:3384:3: (enumLiteral_1= 'TCP' )
                    // InternalEasyWall.g:3385:4: enumLiteral_1= 'TCP'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getTCPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getTCPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3392:3: (enumLiteral_2= 'QUIC' )
                    {
                    // InternalEasyWall.g:3392:3: (enumLiteral_2= 'QUIC' )
                    // InternalEasyWall.g:3393:4: enumLiteral_2= 'QUIC'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getQUICEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getQUICEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:3400:3: (enumLiteral_3= 'SCTP' )
                    {
                    // InternalEasyWall.g:3400:3: (enumLiteral_3= 'SCTP' )
                    // InternalEasyWall.g:3401:4: enumLiteral_3= 'SCTP'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getSCTPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getTRANSPORTLAYERPROTOCOLAccess().getSCTPEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTRANSPORTLAYERPROTOCOL"


    // $ANTLR start "ruleAPPLICATIONLAYERPROTOCOL"
    // InternalEasyWall.g:3411:1: ruleAPPLICATIONLAYERPROTOCOL returns [Enumerator current=null] : ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'HTTPS' ) | (enumLiteral_2= 'SMTP' ) | (enumLiteral_3= 'POP3' ) | (enumLiteral_4= 'IMAP' ) | (enumLiteral_5= 'FTP' ) | (enumLiteral_6= 'TFTP' ) | (enumLiteral_7= 'SNMP' ) | (enumLiteral_8= 'TELNET' ) | (enumLiteral_9= 'SSH' ) | (enumLiteral_10= 'DNS' ) | (enumLiteral_11= 'DHCP' ) ) ;
    public final Enumerator ruleAPPLICATIONLAYERPROTOCOL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;


        	enterRule();

        try {
            // InternalEasyWall.g:3417:2: ( ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'HTTPS' ) | (enumLiteral_2= 'SMTP' ) | (enumLiteral_3= 'POP3' ) | (enumLiteral_4= 'IMAP' ) | (enumLiteral_5= 'FTP' ) | (enumLiteral_6= 'TFTP' ) | (enumLiteral_7= 'SNMP' ) | (enumLiteral_8= 'TELNET' ) | (enumLiteral_9= 'SSH' ) | (enumLiteral_10= 'DNS' ) | (enumLiteral_11= 'DHCP' ) ) )
            // InternalEasyWall.g:3418:2: ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'HTTPS' ) | (enumLiteral_2= 'SMTP' ) | (enumLiteral_3= 'POP3' ) | (enumLiteral_4= 'IMAP' ) | (enumLiteral_5= 'FTP' ) | (enumLiteral_6= 'TFTP' ) | (enumLiteral_7= 'SNMP' ) | (enumLiteral_8= 'TELNET' ) | (enumLiteral_9= 'SSH' ) | (enumLiteral_10= 'DNS' ) | (enumLiteral_11= 'DHCP' ) )
            {
            // InternalEasyWall.g:3418:2: ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'HTTPS' ) | (enumLiteral_2= 'SMTP' ) | (enumLiteral_3= 'POP3' ) | (enumLiteral_4= 'IMAP' ) | (enumLiteral_5= 'FTP' ) | (enumLiteral_6= 'TFTP' ) | (enumLiteral_7= 'SNMP' ) | (enumLiteral_8= 'TELNET' ) | (enumLiteral_9= 'SSH' ) | (enumLiteral_10= 'DNS' ) | (enumLiteral_11= 'DHCP' ) )
            int alt52=12;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt52=1;
                }
                break;
            case 103:
                {
                alt52=2;
                }
                break;
            case 104:
                {
                alt52=3;
                }
                break;
            case 105:
                {
                alt52=4;
                }
                break;
            case 106:
                {
                alt52=5;
                }
                break;
            case 107:
                {
                alt52=6;
                }
                break;
            case 108:
                {
                alt52=7;
                }
                break;
            case 109:
                {
                alt52=8;
                }
                break;
            case 110:
                {
                alt52=9;
                }
                break;
            case 111:
                {
                alt52=10;
                }
                break;
            case 112:
                {
                alt52=11;
                }
                break;
            case 113:
                {
                alt52=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalEasyWall.g:3419:3: (enumLiteral_0= 'HTTP' )
                    {
                    // InternalEasyWall.g:3419:3: (enumLiteral_0= 'HTTP' )
                    // InternalEasyWall.g:3420:4: enumLiteral_0= 'HTTP'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getHTTPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getHTTPEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalEasyWall.g:3427:3: (enumLiteral_1= 'HTTPS' )
                    {
                    // InternalEasyWall.g:3427:3: (enumLiteral_1= 'HTTPS' )
                    // InternalEasyWall.g:3428:4: enumLiteral_1= 'HTTPS'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getHTTPSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getHTTPSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalEasyWall.g:3435:3: (enumLiteral_2= 'SMTP' )
                    {
                    // InternalEasyWall.g:3435:3: (enumLiteral_2= 'SMTP' )
                    // InternalEasyWall.g:3436:4: enumLiteral_2= 'SMTP'
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSMTPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSMTPEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalEasyWall.g:3443:3: (enumLiteral_3= 'POP3' )
                    {
                    // InternalEasyWall.g:3443:3: (enumLiteral_3= 'POP3' )
                    // InternalEasyWall.g:3444:4: enumLiteral_3= 'POP3'
                    {
                    enumLiteral_3=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getPOP3EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getPOP3EnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalEasyWall.g:3451:3: (enumLiteral_4= 'IMAP' )
                    {
                    // InternalEasyWall.g:3451:3: (enumLiteral_4= 'IMAP' )
                    // InternalEasyWall.g:3452:4: enumLiteral_4= 'IMAP'
                    {
                    enumLiteral_4=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getIMAPEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getIMAPEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalEasyWall.g:3459:3: (enumLiteral_5= 'FTP' )
                    {
                    // InternalEasyWall.g:3459:3: (enumLiteral_5= 'FTP' )
                    // InternalEasyWall.g:3460:4: enumLiteral_5= 'FTP'
                    {
                    enumLiteral_5=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getFTPEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getFTPEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalEasyWall.g:3467:3: (enumLiteral_6= 'TFTP' )
                    {
                    // InternalEasyWall.g:3467:3: (enumLiteral_6= 'TFTP' )
                    // InternalEasyWall.g:3468:4: enumLiteral_6= 'TFTP'
                    {
                    enumLiteral_6=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getTFTPEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getTFTPEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalEasyWall.g:3475:3: (enumLiteral_7= 'SNMP' )
                    {
                    // InternalEasyWall.g:3475:3: (enumLiteral_7= 'SNMP' )
                    // InternalEasyWall.g:3476:4: enumLiteral_7= 'SNMP'
                    {
                    enumLiteral_7=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSNMPEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSNMPEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalEasyWall.g:3483:3: (enumLiteral_8= 'TELNET' )
                    {
                    // InternalEasyWall.g:3483:3: (enumLiteral_8= 'TELNET' )
                    // InternalEasyWall.g:3484:4: enumLiteral_8= 'TELNET'
                    {
                    enumLiteral_8=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getTELNETEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getTELNETEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalEasyWall.g:3491:3: (enumLiteral_9= 'SSH' )
                    {
                    // InternalEasyWall.g:3491:3: (enumLiteral_9= 'SSH' )
                    // InternalEasyWall.g:3492:4: enumLiteral_9= 'SSH'
                    {
                    enumLiteral_9=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSSHEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getSSHEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalEasyWall.g:3499:3: (enumLiteral_10= 'DNS' )
                    {
                    // InternalEasyWall.g:3499:3: (enumLiteral_10= 'DNS' )
                    // InternalEasyWall.g:3500:4: enumLiteral_10= 'DNS'
                    {
                    enumLiteral_10=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getDNSEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getDNSEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalEasyWall.g:3507:3: (enumLiteral_11= 'DHCP' )
                    {
                    // InternalEasyWall.g:3507:3: (enumLiteral_11= 'DHCP' )
                    // InternalEasyWall.g:3508:4: enumLiteral_11= 'DHCP'
                    {
                    enumLiteral_11=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getDHCPEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getAPPLICATIONLAYERPROTOCOLAccess().getDHCPEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAPPLICATIONLAYERPROTOCOL"

    // $ANTLR start synpred1_InternalEasyWall
    public final void synpred1_InternalEasyWall_fragment() throws RecognitionException {   
        // InternalEasyWall.g:1103:5: ( 'else' )
        // InternalEasyWall.g:1103:6: 'else'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalEasyWall

    // Delegated rules

    public final boolean synpred1_InternalEasyWall() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalEasyWall_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA35 dfa35 = new DFA35(this);
    static final String dfa_1s = "\27\uffff";
    static final String dfa_2s = "\11\uffff\1\12\7\uffff\1\24\4\uffff\1\24";
    static final String dfa_3s = "\1\4\10\uffff\1\16\7\uffff\1\16\1\uffff\1\4\2\uffff\1\16";
    static final String dfa_4s = "\1\161\10\uffff\1\104\7\uffff\1\103\1\uffff\1\4\2\uffff\1\103";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\13\1\14\1\15\1\16\1\17\1\20\1\uffff\1\12\1\uffff\1\22\1\21\1\uffff";
    static final String dfa_6s = "\27\uffff}>";
    static final String[] dfa_7s = {
            "\1\21\1\1\1\2\1\10\1\11\21\uffff\1\13\1\uffff\1\17\7\uffff\2\3\2\12\1\14\1\15\1\16\5\20\36\uffff\3\4\10\uffff\11\5\4\6\14\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\12\uffff\1\12\3\uffff\2\12\4\uffff\1\12\16\uffff\4\12\2\uffff\14\12\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\24\1\uffff\1\23\10\uffff\1\24\2\uffff\1\25\2\24\4\uffff\1\24\16\uffff\4\24\2\uffff\14\24",
            "",
            "\1\26",
            "",
            "",
            "\1\24\1\uffff\1\23\10\uffff\1\24\2\uffff\1\25\2\24\4\uffff\1\24\16\uffff\4\24\2\uffff\14\24"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1822:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) | ( () ( (lv_value_3_0= RULE_INT ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (lv_direction_7_0= ruleEFDirectionNativeType ) ) ) | ( () ( (lv_protocol_9_0= ruleNETWORKLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_11_0= ruleTRANSPORTLAYERPROTOCOL ) ) ) | ( () ( (lv_protocol_13_0= ruleAPPLICATIONLAYERPROTOCOL ) ) ) | ( () ( (lv_ipv6_15_0= RULE_EFIPV6SYNTAX ) ) ) | ( () ( ( (lv_ipv4_17_0= RULE_EFIPV4SYNTAX ) ) | ( (lv_any_18_0= 'any' ) ) | ( (lv_localhost_19_0= 'localhost' ) ) ) ) | ( () ( (lv_network_21_0= ruleEFNetworkSYNTAX ) ) ) | ( () otherlv_23= ':' ( (lv_netport_24_0= RULE_INT ) ) ) | ( () otherlv_26= 'this' ) | ( () otherlv_28= 'super' ) | ( () otherlv_30= 'new' ( ( ruleQualifiedName ) ) otherlv_32= '(' otherlv_33= ')' ) | ( () otherlv_35= '(' ( (lv_expression_36_0= ruleEFExpression ) ) otherlv_37= ')' ) | this_EFBuiltinFunction_38= ruleEFBuiltinFunction | ( () ( (lv_functionName_40_0= ruleQualifiedName ) ) otherlv_41= '(' ( ( (lv_args_42_0= ruleEFExpression ) ) (otherlv_43= ',' ( (lv_args_44_0= ruleEFExpression ) ) )* )? otherlv_45= ')' ) | ( () ( ( ruleQualifiedName ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0001000000040002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000009D00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00C0FFF0140001F0L,0x0003FFFFFE01C000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003FE0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L,0x0000000000003FE0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00C0FFF3159001F0L,0x0003FFFFFE01C000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00C0FFF3158801F0L,0x0003FFFFFE01C000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0700000000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x7800000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000EL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000810000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00C0FFF0540001F0L,0x0003FFFFFE01C000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x00000000003E0000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000001C00000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000009900000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});

}