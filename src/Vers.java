class Vers
{
    private String text;

    public Vers(String text)
    {
        this.text = text;
    }
    // numararea de cuv.
    public int getNumarCuvinte()
    {
        if (text.trim().length() == 0)
        {
            return 0;
        }
        String[] cuvinte = text.split(" ");  //am folosit fct split pt a diviza un string in mai multe parti
        int count = 0;
        for (String cuvant : cuvinte)
        {
            if (cuvant.length() > 0)
            {
                count++;
            }
        }
        return count;
    }

    public int getNumarVocale()          //Numararea vocalelor
    {
        int count = 0;
        char[] litere = text.toLowerCase().toCharArray();
        for (char c : litere)
        {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean terminare(String grupare)
    {
        if (text.length() < grupare.length())
        {
            return false;
        }
        String sfarsit = text.substring(text.length() - grupare.length());
        return sfarsit.equals(grupare);
    }

    public void transformaInMajuscule()                       //transformarea in majuscule
    {
        char[] litere = text.toCharArray();
        for (int i = 0; i < litere.length; i++)
        {
            if (litere[i] >= 'a' && litere[i] <= 'z')
            {
                litere[i] = (char) (litere[i] - 'a' + 'A');
            }
        }
        text = new String(litere);
    }

   //get set
    public String getText()
    {
        return text;
    }
}