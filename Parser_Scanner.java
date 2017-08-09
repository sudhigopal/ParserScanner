/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser_Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sony
 */
public class Parser_Scanner {

    static BufferedReader f1;
    static String token = "";
    static char ch_new;
    static int lcount = 1;
    static int state = 0;
    static String SYMTAB[][] = new String[100][2];
    static int i = 0;
    static String type = "";
    static int errortype = 1;
    static int stacktop, inputtok, ruleno;
    static int[] stack = new int[100];
    static boolean initial = true, used = true;
    static int stackcount = 0;
    static String inputtokname = "";
    static int stepno = 1;
    
     public static Map<String, String> map = new HashMap();
    static BufferedReader buf;
    static char ch;
    //static String word, type = "";
    static int line = 1;
    //static int i = 1, errortype = 1;

   public static void bookkeeper(String token, String type) {
        if (!map.containsKey(token)) {
            map.put(token, type);
        }
    }

   private static void errorhandler(String token) throws IOException {
        System.out.println("lexical error:");
         if (errortype == 2) {
            System.out.println(token + "\tinvalid identifier\t" + line);
        } else if (errortype == 3) {
            System.out.println(token + "\t\tinvalid constant\t\t" + line);
        } else if (errortype == 4) {
            System.out.println(token + "\t\tinvalid decimal number\t\t" + line);
        }
        errortype = 1;
    }
     public static Boolean Is_Char() {
        return (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K' || ch == 'L' || ch == 'M' || ch == 'N' || ch == 'O' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U' || ch == 'V' || ch == 'W' || ch == 'X' || ch=='x' || ch == 'Y' || ch == 'Z' || ch == 'm');
    }
    
        private static void errorhandler_keyword(String token) throws IOException {
                                while(ch != ';' && ch != ' ' &&ch!='\r'&& ch != '\n' && ch != '$'){
                                                f1.mark(2);
                                                token+=ch;
                                ch=(char)f1.read();
                               
                                }
        System.out.println("lexical error:");
        if (errortype == 1) {
            System.out.println(token + "\t\tinvalid keyword\t\t" + line);
        }
                                if(ch != ';' && ch != ' ' &&ch!='\r'&& ch != '\n' && ch != '$')
                                {
                                state = 0;
                                token = "";
                                }
                                else{
                                f1.reset();
                                state = 0;
                                token = "";
                                }
        errortype = 1;
    }
 public static String scanner() throws IOException {
        String tok = "";
        // uncomment this and comment below same line in parser at start
     //   ch = (char) f1.read();

        state = 0;

        while (ch != '$') {
            switch (state) {
                case 0:

                    if (ch == 'H') {
                        state = 1;
                        tok += ch;
                    } else if (ch == 'F') {
                        state = 20;
                        tok += ch;

                    } else if (ch == 'I') {
                        state = 35;
                        tok += ch;

                    } else if (ch == 'N') {
                        state = 90;
                        tok += ch;

                    } else if (ch == 'W') {
                        state = 110;
                        tok += ch;
                    } else if (ch == 'S') {
                        state = 120;
                        tok += ch;
                    } else if (ch == 'T') {
                        state = 128;
                        tok += ch;
                    } else if (ch == 'V') {
                        state = 135;
                        tok += ch;
                    } else if (ch == 'R') {
                        state = 143;
                        tok += ch;
                    } else if (ch == 'Y') {
                        state = 145;
                        tok += ch;
                    } else if (ch == 'Q') {
                        state = 155;
                        tok += ch;
                    } else if (ch == 'P') {
                        state = 170;
                        tok += ch;
                    } else if (ch == 'K') {
                        state = 181;
                        tok += ch;
                    } else if (ch == 'M') {
                        state = 190;
                        tok += ch;
                    } else if (ch == 'G') {
                        state = 195;
                        tok += ch;
                    } else if (ch == 'E') {
                        state = 205;
                        tok += ch;
                    } else if (ch == 'D') {
                        state = 215;
                        tok += ch;
                    } else if (ch == 'B') {
                        state = 230;
                        tok += ch;
                    } else if (ch == 'O') {
                        state = 250;
                        tok += ch;
                    } else if (ch == 'A') {
                        state = 265;
                        tok += ch;
                    }  else if (ch == 'C' || ch == 'J' || ch == 'L' || ch == 'U' || ch == 'X' || ch == 'Z' ||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z') {
                        state = 107;
                        tok += ch;
                    } else if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                        state = 108;
                       // type = "Constant";
                        tok += ch;

                    }
                    else if(  ch ==';'){
				state = 106; tok+=ch;
                                inputtok=41;
			}
                    else if (ch == ' ' || ch == '\t' || ch == '\t') {
                        ch = (char) f1.read();
                        state = 0;
                    } else if (ch == '\r') {
                        //ch = (char) f1.read();
                        ch = (char) f1.read();
                        state = 0;

                    } else if (ch == '\n') {
                        //ch = (char) f1.read();
                        ch = (char) f1.read();
                        state = 0;
                        line++;
                    } else {

                        state = 0;
                        tok += ch;
                    }

                    break;
                case 1:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'A') {
                        state = 2;
                    } else if (ch == 'O') {
                        state = 4;
                    }
                    else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 2:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'I') {
                        state = 3;
                    }
                else
                    {
                    errortype = 1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                   break;

                case 3:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=3;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                    if(ch==';'){
                         type = "Keyword";
                         inputtok=3;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 4:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'W') {
                        state = 5;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 5:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == ' ') {
                        state = 6;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 6:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'I') {
                        state = 10;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 10:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'Z') {
                        state = 8;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 8:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == ' ') {
                        state = 9;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 9:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'I') {
                        state = 11;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 11:
                    //  tok= End_Of_Line(tok);
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=26;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=26;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 20:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'A') {
                        state = 21;
                    } else if (ch == 'O') {
                        state = 25;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }

                    tok += ch;
                    break;

                case 21:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 22;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 22:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == 'L') {
                        state = 23;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 23:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=23;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=23;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 25:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 26;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 26:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'N') {
                        state = 27;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 27:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'D') {
                        state = 28;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 28:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 29;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 29:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 30;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 30:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 31;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 31:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=24;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=24;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 35:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == ' ') {
                        state = 36;
                    } else if (ch == 'M') {
                        state = 50;
                    } else if (ch == 'F') {
                        state = 68;
                    } else if (ch == 'T') {
                        state = 80;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }

                    tok += ch;
                    break;

                case 36:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 37;
                    } else if (ch == 'I') {
                        state = 38;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 37:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 39;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 39:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'S') {
                        state = 40;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 40:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 41;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 41:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 42;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 42:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=7;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=7;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 38:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Z') {
                        state = 46;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 46:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=29;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=29;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 50:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 51;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 51:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 52;
                    } else if (ch == 'O') {
                        state = 58;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 52:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'N') {
                        state = 53;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 53:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 54;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 54:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 55;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 55:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 56;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 56:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=13;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=13;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 58:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 59;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 59:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 60;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 60:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 61;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 61:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 62;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 62:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 63;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 63:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 64;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 64:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 65;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 65:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=15;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=15;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 68:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 69;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 69:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 301;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                     case 301:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 300;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                          case 300:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 70;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                              
                    
                case 70:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 71;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 71:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'S') {
                        state = 72;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 72:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 73;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 73:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 74;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 74:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 75;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 75:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'S') {
                        state = 76;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 76:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 77;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 77:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=27;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=27;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 80:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Z') {
                        state = 82;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 82:
                    f1.mark(1);
                    ch = (char) f1.read();
                   
                    if (ch == ' ') {
                        state = 83;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 83:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 84;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 84:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=8;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=8;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 90:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 91;
                    } else if (ch == 'U') {
                        state = 100;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 91:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 92;
                    } else if (ch == 'T') {
                        state = 97;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 92:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'W') {
                        state = 93;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 93:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 94;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 94:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 95;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 95:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=18;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=18;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 97:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=38;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=38;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 100:
                    f1.mark(1);
                    ch = (char) f1.read();
                    type = "Keyword";
                    if (ch == 'M') {
                        state = 101;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 101:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'B') {
                        state = 102;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 102:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 103;
                    } else if (ch == 'R') {
                        state = 104;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 103:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 105;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 105:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=10;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=10;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 104:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=9;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=9;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 110:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 111;
                    } else if (ch == 'T') {
                        state = 116;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 111:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'L') {
                        state = 112;
                    } else if (ch == 'N') {
                        state = 113;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 112:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 114;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 114:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=14;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=14;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 113:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=22;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=22;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 116:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 117;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 117:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == '?') {
                        state = 118;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 118:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=20;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=20;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 120:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 121;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 121:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'M') {
                        state = 122;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 122:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 123;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 123:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 124;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 124:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 125;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 125:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=31;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=31;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 128:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 129;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 129:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 130;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 130:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 131;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 131:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 132;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 132:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=11;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=11;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 135:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 136;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 136:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'S') {
                        state = 137;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 137:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 138;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 138:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'B') {
                        state = 139;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 139:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'L') {
                        state = 140;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 140:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 141;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 141:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=6;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=6;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 143:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=12;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=12;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 145:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 146;
                    } else if (ch == 'R') {
                        state = 152;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 146:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 147;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 147:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 148;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 148:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'L') {
                        state = 149;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 149:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 150;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 150:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=17;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=17;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 152:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=28;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=28;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 155:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 156;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 156:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 157;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 157:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'S') {
                        state = 158;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 158:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 160;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 160:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 161;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 161:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'N') {
                        state = 162;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 162:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 163;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 163:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 164;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 164:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 165;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 165:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 166;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 166:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=35;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=35;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;
                case 170:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 171;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 171:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 172;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 172:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'D') {
                        state = 173;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 173:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'U') {
                        state = 174;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 174:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'K') {
                        state = 175;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 175:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 176;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 176:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 177;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 177:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 178;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 178:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 179;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 179:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=34;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=34;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;
                case 181:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 182;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 182:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 183;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 183:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'X') {
                        state = 184;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 184:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'B') {
                        state = 185;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 185:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 186;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 186:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 187;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 187:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=4;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=4;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 190:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'K') {
                        state = 191;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 191:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 192;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 192:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 193;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 193:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=30;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=30;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;
                case 195:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 196;
                    } else if (ch == 'T') {
                        state = 201;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 196:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'M') {
                        state = 197;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 197:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'M') {
                        state = 198;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 198:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 199;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 199:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 200;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 200:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=5;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=5;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 201:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 202;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 202:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 204;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 204:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=25;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=25;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 205:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 206;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 206:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 207;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 207:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 209;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 209:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 210;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 210:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 211;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 211:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 212;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 212:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 213;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 213:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 214;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 214:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=37;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=37;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 215:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 216;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 216:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 217;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 217:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 218;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 218:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 219;
                    } else if (ch == 'R') {
                        state = 223;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 219:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 220;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 220:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 221;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 221:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=33;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=33;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 223:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'I') {
                        state = 224;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 224:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'N') {
                        state = 225;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 225:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 226;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 226:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        state = 0;
                        inputtok=40;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=40;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;
                case 230:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 234;
                    } else if (ch == 'T') {
                        state = 231;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 231:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'W') {
                        state = 232;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 232:
//                    f1.mark(1);
//                    ch = (char) f1.read();
//
//                    if (ch == ' ' || ch == '\n' || ch == '\r') {
//                        type = "Keyword";
//                        state = 0;
//                        f1.reset();
//                        return tok;
//
//                    }
//                     if(ch==';'){
//		       f1.reset();
//	           state = 0;
//	           return tok;
//		      } 
                     
                     /////////////////////////////////////////////////////
                     f1.mark(1);
                     ch = (char) f1.read();
                    if (ch == ' ') {
                        while(ch!= '\n'){
	        		ch= (char) f1.read();
                     //   tok += ch;
	        	}
                        
                  state = 0;
                        type = "Keyword";
                       return tok;

                    }
//                    else{
//                     type = "Keyword";
//                     //   state = 0;
//                        f1.reset();
//                        return tok;
//                    
//                    }
                    
                   
                    break;
                case 234:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'T') {
                        state = 235;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 235:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'H') {
                        state = 236;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 236:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 237;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 237:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'O') {
                        state = 238;
                    } else if (ch == 'S') {
                        state = 240;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 238:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'F') {
                        state = 239;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 239:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=36;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=36;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 240:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'A') {
                        state = 241;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 241:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'E') {
                        state = 242;
                    }else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 242:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'M') {
                        state = 243;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 243:
                    f1.mark(1);
                    ch = (char) f1.read();
                   inputtok=39;
                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 250:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ') {
                        state = 251;
                    } else if (ch == 'I') {
                        state = 256;
                    } else if (ch == 'M') {
                        state = 258;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 251:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'R') {
                        state = 252;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 252:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'L') {
                        state = 253;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 253:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'Y') {
                        state = 254;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 254:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == '?') {
                        state = 255;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 255:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=16;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=16;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;
                case 256:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'C') {
                        state = 257;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;

                case 257:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=19;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=19;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 258:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'G') {
                        state = 259;
                    } else
                    {
                    errortype=1;
                        errorhandler_keyword(tok);
                    }
                    tok += ch;
                    break;
                case 259:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=21;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=21;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
                    break;

                case 265:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == 'N') {
                        state = 266;
                    } 
                   
//                    } else if (Is_Char()) {
//                        state = 107;
//                    } else if (ch == ' ' || ch == '\n' || ch == ',' || ch == ';' || ch == ':') {
//                        f1.reset();
//                        state = 0;
//                        return tok;
//                    } else {
//                        System.out.print("error c3");
//                    }
                    tok += ch;
                    break;

                case 266:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == ' ' || ch == '\n' || ch == '\r') {
                        type = "Keyword";
                        inputtok=32;
                        state = 0;
                        f1.reset();
                        return tok;

                    }
                     if(ch==';'){
                         inputtok=32;
		       f1.reset();
	           state = 0;
	           return tok;
		      } 
//                     else
//                    {
//                  //    type=  "invalid keyword";
//                        errortype=1;
//                        errorhandler_keyword(tok);
//                    }
                      if (Is_Char()) {
                        state = 107;
                        tok += ch;
                    }
                    
   //                    tok += ch;
                    break;

                case 107:
                    f1.mark(1);
                    ch = (char) f1.read();

                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                        state = 107;
                        tok += ch;
                    } else if (ch == '.') {
                        state = 107;
                        tok += ch;
                    } else if (ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K' || ch == 'L' || ch == 'M'
                            || ch == 'N' || ch == 'O' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U' || ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z'||ch=='a'||ch =='b'||ch =='c'||ch =='d'||ch =='e'||ch =='f'||ch =='g'||ch =='h'||ch =='i'||ch =='j'||ch =='k'||ch =='l'||ch =='m'||
		        		ch =='n'||ch =='o'||ch =='p'||ch =='q'||ch=='r'||ch =='s'||ch =='t'||ch =='u'||ch =='v'||ch =='w'||ch =='x'||ch =='y'||ch =='z') {
                        state = 107;
                        tok += ch;
                        inputtok=1;
                    } else {
                        f1.reset();
                        inputtok=1;
                        state = 0;
                        type = "Identifier";
                        bookkeeper(tok, "identifier");

                        return tok;
                    }

                    break;

                case 108:
                    f1.mark(1);
                    ch = (char) f1.read();
                  //  type = "Constant";
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                        state = 108;
                        inputtok=2;
                        tok += ch;
                        
                    } else if (ch == '.') {
                        state = 109;
                        tok += ch;
                    } else if (ch == ' ' || ch == '\n' || ch == '\r' || ch == '$') {
                        f1.reset();
                        state = 0;
                        inputtok=2;
                         type = "Constant";
                        bookkeeper(tok, "constant");
                        return tok;
                    }
                    else if(ch==';'){
                        inputtok=2;
                     //    type = "Special Symbol";
		       f1.reset();
	           state = 0;
	           return tok;
		      }
                    else {
                        type = "invalid identifier";
                        state = 0;
                        errortype = 2;
                        //   tok+=ch;
                        tok += ch;
                        errorhandler(tok);

		        	 // errorhandler_keyword(tok, state);
                        //  bookkeeper(tok, "constant");
                        return tok;
                    }

                    break;

                case 109:
                    f1.mark(1);
                    ch = (char) f1.read();
                    if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                        state = 109;
                        tok += ch;
                    } else if (ch == ' ' || ch == '\n' || ch == '\r' || ch == '$') {
                        state = 0;
                       // inputtok=2;
                        type = "Constant";
                        bookkeeper(tok, "constant");
                        return tok;
                    } else if (ch == ';') {
                        f1.reset();
                       // inputtok=1;
                        state = 0;
                        type = "Constant";
                        bookkeeper(tok, "constant");
                        return tok;
                    } else {
                        state = 0;
                        errortype = 3;
                   
                         tok += ch;
                        f1.mark(1);
                        type = "invalid constant";
                   ch = (char) f1.read();
                 
                       tok += ch;
                        errorhandler(tok);
                 //   errorhandler_keyword(tok);
                        return tok;


                    }

                    break;
                    
                    case 106:  f1.mark(1);
	        inputtok=41;
			if(ch== ' '){
	        	while(ch!= '\n'){
	        		ch= (char) f1.read();
	        	}
	        }
	        
			else if( ch ==';' || ch == '{' || ch == '}' || ch =='(' || ch ==')'||
					ch == ':' || ch == ',' ||ch == '='||ch =='+' ||ch == '*'||ch == '@') {
	        
	        	state =0;  
			     return tok; 
			     }
	        
	        
	        else if(  ch=='\n') {
	        
		           state = 0;
		           f1.reset(); line++;
		           return tok; 
		           }
	        else if( ch== ' ') {
		        
		           state = 0;
		           f1.reset();
		           return tok; 
		           }
	        //else{ System.out.print("error");}
			
	        break;
            }

        }
        return tok;
    }
   

    public static void parserfunc() throws IOException {
        token = "";
        ch = (char) f1.read();
        state = 0;
        //Scanner_new p=new Scanner_new();
        inputtokname = scanner();
        if (initial) {
            push(42);
            System.out.println(stepno + "  " + "Zo" + "  " + "0" + "  " + "--" + "  " + "--" + "  " + "push <lol>");
            stepno++;
            initial = false;
        }
        //stacktop inputtok ruleno
        while (true) {

            stacktop = stack[stackcount];
		//used = false;

            if (inputtok == stacktop) {//for match operation to be done
                match();
                //used = true;
                continue;
            } //else if part must only be written for the non terminals because only non terminals expand
            else if (inputtok != stacktop && !inputtokname.equals("$") && stacktop != 0) {
			// Here the code goes for each non terminal token
			/*if(stacktop == 42){
                 //from here you need to call the look ahead! or do we need to? no we just can set depending on the input symbol which rule to use here itself
				
                 }*/
                switch (stacktop) {
                    case 42:
	//System.out.println("i reached here42");
                        //we can implement the look ahead here! and we can set the rule No variable
                        switch (inputtok) {
                            case 3:
	//System.out.println("i reached here");
                                // if any of these cases we are using the rule no.1
                                ruleno = 1;
                                pop();
                                
                                
                                push(4);
                                push(43);
                                push(3);
                                printout();
                                break;
                        }
                        break;
                    case 43:
                        switch (inputtok) {
                            case 5:
                            case 6:
                            case 7:
                            case 1:
                            case 13:
                            case 16:
                            case 20:
                            case 24:
                            case 25:
                            case 26:
                            case 29:
                                ruleno = 2;
                                pop();
                                push(43);
                                push(41);
                                push(44);
                               // push(43);

                                printout();
                                break;
                            case 4:
                            case 18:
                            case 19:
                            case 15:
                            case 21:
                            case 27:
                                ruleno = 3;
                                pop();
                                printout();
                                break;
                        }
                        break;

                    case 44:
                        switch (inputtok) {
                            case 5:
                                ruleno = 4;
                                pop();
                                push(45);
                                printout();
                                break;
                            case 6:
                                ruleno = 5;
                                pop();
                                push(46);
                                printout();
                                break;
                            case 7:
                                ruleno = 6;
                                pop();
                                push(47);
                                printout();
                                break;
                            case 1:
                                ruleno = 7;
                                pop();
                                push(48);
                                printout();
                                break;
                            case 13:
                                ruleno = 8;
                                pop();
                                push(49);
                                printout();
                                break;
                            case 16:
                                ruleno = 9;
                                pop();
                                push(50);
                                printout();
                                break;
                            case 20:
                                ruleno = 10;
                                pop();
                                push(51);
                                printout();
                                break;
                            case 24:
                            case 25:

                                ruleno = 11;
                                pop();
                                push(52);
                                printout();
                                break;
                            case 26:
                                ruleno = 12;
                                pop();
                                push(53);
                                printout();
                                break;
                            case 29:
                                ruleno = 13;
                                pop();
                                push(54);
                                printout();
                                break;
                        }
                        break;
                    case 45:
                        //System.out.println("i am here at 45");
                        switch (inputtok) {
                            case 5:
                                ruleno = 14;
                                pop();
                                push(1);
                                push(5);
                                printout();
                                break;
                        }
                        break;
                    case 46:

                        switch (inputtok) {

                            case 6:
                                ruleno = 15;
                                pop();
                                push(55);
                                push(6);
                                printout();
                                break;
                        }
                        break;
                    case 47:
                        switch (inputtok) {

                            case 7:
                                ruleno = 16;
                                pop();
                                push(56);
                                push(8);
                                push(1);
                                push(7);
                                printout();
                                break;

                        }
                        break;
                    case 56:
                        switch (inputtok) {
                            case 9:
                                ruleno = 17;
                                pop();
                                push(9);
                                printout();
                                break;
                            case 10:
                                ruleno = 18;
                                pop();
                                push(10);
                                printout();
                                break;
                            case 11:
                                ruleno = 19;
                                pop();
                                push(11);
                                printout();
                                break;
                        }
                        break;
                    case 48:
                        switch (inputtok) {
                            case 1:
                                ruleno = 20;
                                pop();
                                push(55);
                                push(12);
                                push(1);
                                printout();
                                break;

                        }
                        break;
                    case 49:
                        switch (inputtok) {
                            case 13:
                                ruleno = 21;
                                pop();
                                push(1);
                                push(15);
                                push(43);
                                push(57);
                                push(14);
                                push(1);
                                push(13);
                                printout();
                                break;
                        }
                        break;
                    case 50:
                        switch (inputtok) {
                            case 16:
                                ruleno = 22;
                                pop();

                                push(19);
                                push(43);
                                push(18);
                                push(43);
                                push(17);
                                push(57);
                                push(16);
                                printout();
                                break;

                        }
                        break;
                    case 51:
                        switch (inputtok) {
                            case 20:
                                ruleno = 23;
                                pop();

                                push(19);
                                push(58);
                                push(55);
                                push(20);
                                printout();
                                break;

                        }
                        break;
                    case 58:
                        switch (inputtok) {
                            case 21:
                                ruleno = 24;
                                pop();
                                push(58);
                                push(59);
                                //push(58);
                                printout();
                                break;
                            case 19:
                                ruleno = 25;
                                pop();
                                printout();
                                break;

                        }
                        break;
                    case 59:
                        switch (inputtok) {
                            case 21:
                                ruleno = 26;
                                pop();
                                push(43);
                                push(60);
                                push(21);
                                printout();
                                break;
                        }
                        break;
                    case 60:
                        switch (inputtok) {
                            case 2:
                                ruleno = 27;
                                pop();
                                push(2);
                                printout();
                                break;
                            case 22:
                                ruleno = 28;
                                pop();
                                push(22);
                                printout();
                                break;
                            case 23:
                                ruleno = 29;
                                pop();
                                push(23);
                                printout();
                                break;
                        }
                        break;
                    case 52:
                        switch (inputtok) {
                            case 24:
                                ruleno = 30;
                                pop();
                                push(55);
                                push(24);
                                printout();
                                break;

                            case 25:
                                ruleno = 31;
                                pop();
                                push(25);
                                printout();
                                break;
                        }
                        break;
                    case 53:
                        switch (inputtok) {
                            case 26:
                                ruleno = 32;
                                pop();
                                push(27);
                                push(43);
                                push(61);
                                push(1);
                                push(26);
                                printout();
                                break;
                        }
                        break;
                    case 61:
                        switch (inputtok) {
                            case 28:
                                ruleno = 33;
                                pop();
                                push(61);
                                push(62);
                                printout();
                                break;
                            case 5:
                            case 6:
                            case 7:
                           // case 8:
                            
                            case 1:
                            case 13:
                            case 16:
                            case 20:
                            case 24:
                            case 25:
                            case 26:
                            case 29:
                            case 27:
                            case 30:
                                ruleno = 34;
                                pop();
                                printout();
                                break;

                        }
                        break;
                    case 62:
                        switch (inputtok) {
                            case 28:
                                ruleno = 35;
                                pop();
                                push(1);
                                push(28);
                                printout();
                                break;
                        }
                        break;
                    case 54:
                        switch (inputtok) {
                            case 29:
                                ruleno = 36;
                                pop();
                                push(30);
                                push(61);
                                push(1);
                                push(29);
                                printout();
                                break;
                        }
                        break;
                    case 55:
                        switch (inputtok) {
                            case 31:
                            case 33:
                            case 34:
                            case 35:
                            case 1:
                            case 2:
                                ruleno = 37;
                                pop();
                                push(63);
                                printout();
                                break;
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 22:
                            case 23:
                                ruleno = 38;
                                pop();
                                push(57);
                                printout();
                                break;
                        }
                        break;
                    case 63:
                        switch (inputtok) {
                            case 31:
                                ruleno = 39;
                                pop();
                                push(63);
                                push(32);
                                push(63);
                                push(31);
                                printout();
                                break;
                            case 33:
                                ruleno = 40;
                                pop();
                                push(63);
                                push(32);
                                push(63);
                                push(33);
                                printout();
                                break;
                            case 34:
                                ruleno = 41;
                                pop();
                                push(63);
                                push(32);
                                push(63);
                                push(34);
                                printout();
                                break;
                            case 35:
                                ruleno = 42;
                                pop();
                                push(63);
                                push(32);
                                push(63);
                                push(35);
                                printout();
                                break;
                            case 1:
                                ruleno = 43;
                                pop();
                                push(1);
                                printout();
                                break;
                            case 2:
                                ruleno = 44;
                                pop();
                                push(2);
                                printout();
                                break;

                        }
                        break;
                    case 57:
                        switch (inputtok) {
                            case 36:
                                ruleno = 45;
                                pop();
                                push(57);
                                push(32);
                                push(57);
                                push(36);
                                printout();
                                break;
                            case 37:
                                ruleno = 46;
                                pop();
                                push(57);
                                push(32);
                                push(57);
                                push(37);
                                printout();
                                break;
                            case 38:
                                ruleno = 47;
                                pop();
                                push(57);
                                push(38);
                                printout();
                                break;
                            case 39:
                            case 40:
                                ruleno = 48;
                                pop();
                               // push(35);
                                push(64);
                                printout();
                                break;
                            case 22:
                                ruleno = 49;
                                pop();
                                push(22);
                                printout();
                                break;
                            case 23:
                                ruleno = 50;
                                pop();
                                push(23);
                                printout();
                                break;

                        }
                        break;
                    case 64:
                        switch (inputtok) {
                            case 39:
                                ruleno = 51;
                                pop();
                                push(55);
                                push(32);
                                push(55);
                                push(39);
                                printout();
                                break;
                            case 40:
                                ruleno = 52;
                                pop();
                                push(55);
                                push(32);
                                push(55);
                                push(40);
                                printout();
                                break;
                        }
                        break;

                    default:

                        System.out.println("fault");
                        System.out.println(stepno + "  " + name(stacktop) + "  " + stacktop + "  " + inputtokname + "  " + inputtok + "  " + "rule no.(" + ruleno + ")");
                        break;

                }

            } 
            else if(stacktop==0)
            {
            System.out.println("ACCEPT"); break;
                    }
            else {
                System.out.println("Seems to be some error");
                break;
            }

        }
        
//        if(stacktop ==0)
//        {
//        System.out.println("ACCEPT");
//        }

    }

    private static void printout() {
        // TODO Auto-generated method stub
        System.out.println(stepno + "  " + name(stacktop) + "  " + stacktop + "  " + inputtokname + "  " + inputtok + "  " + "rule no.(" + ruleno + ")");
        stepno++;
    }

    private static void match() throws IOException {
	// TODO Auto-generated method stub
        //this should match and pop the element from the stack
        // a function which returns strings for the integer values
        //The step || The Stack Top || The associated No. || The Input symbol ||The  Associated No. || The rule or what we are using
        //name is a function which returns the associated name for a particular no.

        System.out.println(stepno + "  " + name(stacktop) + "  " + stacktop + "  " + inputtokname + "  " + inputtok + "  " + "Match");
        stepno++;
        pop();
        token = "";
        ch = (char) f1.read();
        state = 0;
        inputtokname = scanner();
        System.out.println("next : " + stack[stackcount] + name(stack[stackcount]) + inputtok + inputtokname);
    }

    private static String name(int stacktop2) {
	// TODO Auto-generated method stub
	switch(stacktop2){
	case 1: return "[id]";
	case 2: return "[const]";
	case 3: return "HAI";
	case 4: return "KTHXBYE";
	case 5: return "GIMMEH";
	case 6: return "VISIBLE";
	case 7: return "I HAS A";

	case 8: return "ITZ A";
	case 9: return "NUMBR";
	case 10: return "NUMBAR";
	case 11: return "TROOF";
	case 12: return "R";
	case 13: return "IM IN YR";
	case 14: return "WILE";

	case 15: return "IM OUTTA YR";
	case 16: return "O RLY?";
	case 17: return "YA RLY";
	case 18: return "NO WAI";
	case 19: return "OIC";
	case 20: return "WTF?";
	case 21: return "OMG";

	case 22: return "WIN";
	case 23: return "FAIL";
	case 24: return "FOUND YR";
	case 25: return "GTFO";
	case 26: return "HOW IZ I";
	case 27: return "IF U SAY SO";
	case 28: return "YR";

	case 29: return "I IZ";
	case 30: return "MKAY";
	case 31: return "SUM OF";
	case 32: return "AN";
        case 33: return "DIFF OF";
	case 34: return "PRODUKT OF";
	case 35: return "QUOSHUNT OF";
	
	case 36: return "BOTH OF";
	case 37: return "EITHER OF";
	case 38: return "NOT";
	case 39: return "BOTH SEAM";
	case 40: return "DIFFRINT";
	case 41: return ";";
	case 42: return "<lol>";

	case 43: return "<body>";
	case 44: return "<stmt>";
	case 45: return "<input>";
	case 46: return "<output>";
	case 47: return "<decl>";
	case 48: return "<asmt>";
	case 49: return "<loop>";

	case 50: return "<if>";
	case 51: return "<case>";
	case 52: return "<return>";
	case 53: return "<function>";
	case 54: return "<call>";
	case 55: return "<expr>";
	case 56: return "<type>";

	case 57: return "<bool>";
	case 58: return "<omgs>";
	case 59: return "<omg>";
	case 60: return "<value>";
	case 61: return "<args>";
	case 62: return "<arg>";
	case 63: return "<arith>";
	case 64: return "<comp>";
        default: return "invalid";
    }
	
}

    public static void push(int x) {
        stack[++stackcount] = x;
    }

    public static int pop() {
        int j = stack[stackcount--];
        stack[stackcount + 1] = 0;
        return j;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("-------------Input Program--------------");
        f1 = new BufferedReader(new FileReader("C:/parse_input.txt"));//opening the fileint x=f2.available();
        char r = 'x';
        while (r != '$') {
            r = (char) f1.read();
            System.out.print(r);
        }
        f1.close();
        System.out.println("\n-------------Parser-----------");
        f1 = new BufferedReader(new FileReader("C:/parse_input.txt"));//opening the file
        push(0);//initiall 0 is the stack bottom.
        parserfunc();//calling the parser from the main program.
        System.out.println("\n---------------SYMTAB-------------------");
        int nk = 0;
        while (nk < i) {
            System.out.println(SYMTAB[nk][0] + "\t" + SYMTAB[nk][1]);
            nk++;
        }
    }//close main
}
