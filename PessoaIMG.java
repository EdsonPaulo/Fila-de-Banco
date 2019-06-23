package FilaBanco;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PessoaIMG extends JLabel {
    ImageIcon imagem = new ImageIcon(getClass().getResource("/FilaBanco/pessoa.png"));    
    public PessoaIMG(String text) 
    {
        this.setText(text);
        this.setIcon(imagem);
        this.setSize(100, 45);
        this.setVisible(true);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
