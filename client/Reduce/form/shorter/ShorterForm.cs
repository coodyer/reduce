using Reduce.impl;
using Reduce.impl.schema;
using Reduce.impl.vo.msg;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Reduce.form.shorter
{
    public partial class ShorterForm : Form
    {
        private MainForm mainForm;
        private String unionId;
        public ShorterForm(MainForm mainForm, String unionId)
        {
            InitializeComponent();
            this.unionId = unionId;
            this.mainForm = mainForm;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ShortImpl impl = new ShortImpl();
            String url = UrlTextBox.Text;
            MsgEntity<String> msg = impl.create(unionId, url);
            if (msg.Code!=200) {
                MessageBox.Show(msg.Msg);
                return;
            }
            mainForm.loadShortList();
            this.Close();
        }

        private void ShorterForm_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
