using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine((int)'Z');

            Console.WriteLine("enter your plain test : ");
            String plain_text = Console.ReadLine();


            Console.WriteLine("enter your key : ");
            String Keey = Console.ReadLine();
            encrptttt(plain_text, Keey);
        }
        /* for (int i = 0; i < plain.Length; i++)
           {
               char p = plain[i];
               char k = ciphr[i];
               Str_ret += shft_analiz(p, k);
           }
           Str_ret = getreal(Str_ret);
           Console.WriteLine(Str_ret.ToLower());
           */
        /*String Str_ret = "";
        String plain = worPla.ToUpper();
        String key = cipherText.ToUpper();
        int t = (plain.Length - key.Length);
        for (int i = 0; i < t; i++)
        {
            key += plain[i];
        }
        for (int i = 0; i < plain.Length; i++)
        {
            char p = plain[i];
            char k = key[i];
            Str_ret += shft_enc(p, k);
        }*/
        static void encrptttt(String worPla, String worKe) {



            String Str_ret = "";
            String plain = worPla.ToUpper();
            String key = worKe.ToUpper();
            //  key = get_key(plain, key);
            for (int i = 0; i < plain.Length; i++)
            {
                char p = plain[i];
                char k = key[i];
                char x = shft_DEC(p, k); ;
                Str_ret += x;
                key += x;
            }
            //String Str_ret = "";
            //String plain = worPla.ToUpper();
            //String ciphr = worKe.ToUpper();
            //for (int i = 0; i < plain.Length; i++)
            //{
            //    char p = plain[i];
            //    char k = ciphr[i];
            //    Str_ret += shft_enc(p, k);
            //}

            //Str_ret = getreal(Str_ret, plain);
            Console.WriteLine(Str_ret);

         
        }
      
        static String get_key(String plain, String key)
        {
            int t = (plain.Length - key.Length);
            for (int i = 0; i < t; i++)
            {
                key += plain[i];
            }
            return key;
        }
        static String getreal(String key, String plain)
        {
            String ret = "";
            String mor = "";
            int con = 0;
            for (int i = 0; i < key.Length; i++)
            {
                if (key[i].Equals(plain[con]))
                {
                    int j = i;
                    for (; j < key.Length; j++,con++) {
                        if (key[j].Equals(plain[con])) { mor += key[j]; }
                        else {
                            ret += mor;
                            ret+= key[j];
                            mor = "";
                            
                            con = 0;
                            break;
                        }

                    }
                    i = j;
                }
                else ret += key[i];


            }

            return ret;
        }
        static char shft_enc(char p, char k)
        {
            if ((char)(p + (k % 65)) > 'Z')
            {
                int r = (p + (k % 65)) % 90;
                r += 64;
                return (char)r;

            }

            return (char)(p + (k % 65));
        }

        static char shft_DEC(char p, char k)
        {


            if ((char)(p - (k % 65)) < 'A')
            {
                int r = (p - (k % 65));
                r += 26;
                return (char)r;
            }
            return (char)(p - (k % 65));

        }
        static String getreal(String str_ret)
        {
            String rel_ret ="" ;

            rel_ret += str_ret[0];
              for (int i = 1; i < str_ret.Length; i++)
              {
                if (rel_ret[0].Equals(str_ret[i]))
                {
                    if (rel_ret[1].Equals(str_ret[i + 1]) )
                    {

                        break;
                    }
                    else rel_ret += str_ret[i];

                }
                else {
                    rel_ret += str_ret[i];
                }
              }

            return rel_ret;
        }
        static char shft_analiz(char p, char c)
        {
            if (c >= p)
            {
                return (char)(65+(c - p));
            }
            else 
            {
                int r = p - c;
                return (char)(65 + (26 - r));
            }

            
        }
    }
}
