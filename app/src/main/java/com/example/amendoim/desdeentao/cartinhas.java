package com.example.amendoim.desdeentao;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class cartinhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartinhas);
    }

    public void onPrimeira (View view) {
        AlertDialog.Builder Primeira = new AlertDialog.Builder(this);

        Primeira.setTitle("💌 Abra quando usar o app pela primeira vez!!");
        Primeira.setMessage("Oii Enzo!! Eu fiz esse app de presente pra você, pois sei o quanto você gosta de DS! " +
                "" +
                "Sempre vou atualizar, " +
                "colocar mais coisas que me lembram de vc, mais funcionalidades, e se você quiser eu até tento fazer um sistema de touhou e de jogos parecidos! " +
                "Espero que aprecie, esse app foi feito com muito carinho, amor e dedicação. " +
                "Com amor, bolo!!");

        Primeira.setPositiveButton("Fechar cartinha!", null);

        Primeira.show();
    }

    public void onTriste (View view) {
        AlertDialog.Builder Triste = new AlertDialog.Builder(this);

        Triste.setTitle("💌 Abra se estiver triste");
        Triste.setMessage("Poxa, se você abriu essa cartinha especial, quer dizer que vc tá tristinho? " +
                        "Não fica assim não meu amor! O que houve pra você estar assim cabisbaixo? Todo murxinho? " +
                        "Me manda mensagem, conversa comigo, eu quero te ajudar. " +
                        "Você é importante pra mim, e te ver triste é algo que me machuca muito! " +
                        "" +
                        "Bebe um leite quente, joga um pouco, descansa! Sua mente trabalha demais, para um pouqunho de viver a vida corrida e aproveita os pequenos momentos. " +
                "" +
                "Eu te amo viu, não desista, se anime!");

        Triste.setPositiveButton("Fechar cartinha!", null);

        Triste.show();
    }

    public void onOrgulhoso (View view) {
        AlertDialog.Builder Orgulhoso = new AlertDialog.Builder(this);

        Orgulhoso.setTitle("💌 Abra quando estiver se sentindo orgulhoso!");
        Orgulhoso.setMessage("Se vc abriu essa carta, espero que vc tenha conseguido algo muito legal!! " +
                "" +
                        "As vezes você não percebe o quanto evoluiu, mas eu percebo. E a cada vez fico mais orgulhoso de vc! " +
                "" +
                "Continue sendo esse menino esperto, inteligente, legal, engraçado e bom desenhista que vc eh!!.");

        Orgulhoso.setPositiveButton("Fechar cartinha!", null);

        Orgulhoso.show();
    }

    public void onCuriosidade (View view) {
        AlertDialog.Builder Curiosidade = new AlertDialog.Builder(this);

        Curiosidade.setTitle("💌 Abra por curiosidade ");
        Curiosidade.setMessage("Uai?! Abriu porque? Você é muito curioso, seu fofo! Sai sai!! ");

        Curiosidade.setPositiveButton("Fechar cartinha!", null);

        Curiosidade.show();
    }

    public void onSaudade (View view) {
        AlertDialog.Builder Saudade = new AlertDialog.Builder(this);

        Saudade.setTitle("💌 Abra quando sentir saudade!");
        Saudade.setMessage("Ahh, vc tá com sdds mô? Sabia que eu também tô com MUITA saudade sua? Sempre sinto sua falta :(( " +
                        "Quando eu for te ver denovo, vou te dar um abração que vc nunca mais vai esquecer! Vai ficar uma marca de mim em vc!! " +
                        "" +
                        "Sempre que sentir minha falta denovo, me manda mensagem, pq eu vou ir correndo pra sua casa mô!! A gente vai matar a saudade comendo, assistindo e jogando!!");

        Saudade.setPositiveButton("Fechar cartinha!", null);

        Saudade.show();
    }

    public void onAmo (View view) {
        AlertDialog.Builder Amo = new AlertDialog.Builder(this);

        Amo.setTitle("💌 Abra quando quiser saber o quanto eu te amo! ");
        Amo.setMessage("Eu te amo mil milhões! " +
                        "Eu viajaria de Osasco até a China a pé se você pedisse. " +
                        "Eu roubaria a estrela mais bonita do céu pra você observar. " +
                        "Eu compraria um cinema inteiro só para você assistir seu filme favorito. " +
                        "Se eu pudesse, eu te abraçaria pra todo o sempre! " +
                        "Eu te amo muito!! ");

        Amo.setPositiveButton("Fechar cartinha!", null);

        Amo.show();
    }

    public void onFeio (View view) {
        AlertDialog.Builder Feio = new AlertDialog.Builder(this);

        Feio.setTitle("💌 Abra quando se sentir feio ");
        Feio.setMessage("Oi?! Você feio? " +
                        "Você é o homem mais lindo que eu já conheci em toda a minha vida... " +
                        "Seus olhos são como espelhos que refletem um buraco negro que me prende em seu olhar. " +
                "" +
                        "Sua voz ecoa em meus ouvidos como a onda do mar na costa de uma praia. " +
                "" +
                        "Seu toque gelado me faz ter arrepios de felicidade. " +
                "" +
                        "Seu sorriso, hihi, até fico bobo pensando no seu sorriso! Quando você ri, tem o rosto mais lindo do mundo, mais fofo!! " +
                "" +
                        "Seu abraço é como um cobertor quentinho em um dia frio e chuvoso! " +
                        "" +
                        "Você é o homem mais perfeito que já conheci. ");

        Feio.setPositiveButton("Fechar cartinha!", null);

        Feio.show();
    }

    public void onDesenho (View view) {
        AlertDialog.Builder Desenho = new AlertDialog.Builder(this);

        Desenho.setTitle("💌 Abra quando quiser uma inspiração de desenho! ");
        Desenho.setMessage("Bom, no momento eu tenho uma inspiração muito boa! " +
                        "" +
                        "Imagina uma mulher sentada na beira de um lago olhando para o céu, de modo que ela passe um ar de calmaria. " +
                        "No fundo terá uma ameaça, mas essa ameaça também tem a expressão de calmaria. " +
                        "" +
                        "E ai, que tal!? ");

        Desenho.setPositiveButton("Fechar cartinha!", null);

        Desenho.show();
    }

    public void onDoente (View view) {
        AlertDialog.Builder Doente = new AlertDialog.Builder(this);

        Doente.setTitle("💌 Abra quando estiver doentinho! ");
        Doente.setMessage("Poxa mô, denovo doente? Eu tenho tanta dó de vc, se eu pudesse, eu pegava todas essas doenças malvadas e lutava contra elas pra vc sempre ficar saudável!!" +
                        "" +
                "Te ver doentinho me deixa triste, mas sei que você é frágil. " +
                        "Tem que comer mais arroz e feijão! Desse jeito, logo logo vc vai estar que nem um esqueletinho hihi ");

        Doente.setPositiveButton("Fechar cartinha!", null);

        Doente.show();
    }

    public void onApp (View view) {
        AlertDialog.Builder App = new AlertDialog.Builder(this);

        App.setTitle("💌 Abra quando terminar de explorar o app! ");
        App.setMessage("Esse vai ser o mais longo! " +
                        "" +
                        "Bom, desde o dia em que te vi pela primeira vez (09/02) me apaixonei por completo. Tentei ignorar, minha mente mandava eu gostar de outra pessoa, e cada vez mais eu ia me machucando. " +
                        "Sua voz era bonita, seu jeito era misterioso, sua feição... Oh, nem se fala. " +
                        "Sempre estive tentando me motivar a falar contigo... Quando você apresentou o trabalho de artes, percebi que você não era só mais um NPC, percebi que você não era só mais um naquele lugar, você era comum, e seria uma das oportunidades que eu teria de ter um motivo para viver... " +
                        "Aos poucos me aproximei, primeiro conversei com o Erick, depois com o Miguel, Isaac, Samuel, até chegar em você... E ai eu finalmente percebi, o tchan já tinha rolado! Mesmo que eu não seja igual você, não fale as mesmas estranhesas, ou haja do mesmo jeito, eu me esforço muito pra você também me ver do jeito que te vejo... Suas piadas, seu jeito peculiar, sua forma de falar, sua inteligência!!! Tudo me encanta. " +
                        "" +
                        "Mesmo que você não sinta o mesmo, eu me alegro só de pensar que consegui vencer meus medos e falei contigo. " +
                        "Eu realmente te amo, e mesmo que seja só como amigo. Você e o grupinho salvaram a minha vida da perdição. " +
                        "Literalmente 💓 ");

        App.setPositiveButton("Fechar cartinha!", null);

        App.show();
    }
}
