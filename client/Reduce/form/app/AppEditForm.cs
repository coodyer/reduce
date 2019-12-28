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

namespace Reduce.form.app
{
    public partial class AppEditForm : Form
    {
        private String appId;
        private MainForm mainForm;
        public AppEditForm(MainForm mainForm, String appId)
        {
            InitializeComponent();
            this.mainForm = mainForm;
            this.appId = appId;
        }
        public AppEditForm(MainForm mainForm)
        {

            InitializeComponent();
            this.mainForm = mainForm;

        }
        private void AppEditForm_Load(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(appId))
            {
                return;
            }
            AppImpl impl = new AppImpl();
            MsgEntity<AppInfo> msg = impl.info(appId);
            AppNameTextBox.Text = msg.Datas.Name;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            AppImpl impl = new AppImpl();
            AppInfo app = new AppInfo();
            app.Name = AppNameTextBox.Text;
            if (!String.IsNullOrEmpty(appId))
            {
                app.Id = appId;
            }
            MsgEntity<String> msg = impl.save(app);
            MessageBox.Show(msg.Msg);
            if (msg.Code == 200)
            {
                mainForm.loadAppList();
                this.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }


    }
}
