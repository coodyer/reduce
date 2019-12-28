using Reduce.form.app;
using Reduce.form.shorter;
using Reduce.impl;
using Reduce.impl.container;
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

namespace Reduce
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void Main_Load(object sender, EventArgs e)
        {
            loadAppList();
            loadShortList();
        }

        public void loadAppList()
        {
            AppInfoListView.Items.Clear();
            AppImpl impl = new AppImpl();
            MsgEntity<List<AppInfo>> msg = impl.list();
            if (msg.Code != 200)
            {
                return;
            }

            foreach (AppInfo app in msg.Datas)
            {
                ListViewItem lvi = new ListViewItem();
                lvi.SubItems[0].Text = Convert.ToString(app.Id);
                lvi.SubItems.Add(app.Name);
                lvi.SubItems.Add(app.UnionId);
                lvi.SubItems.Add(String.Format("{0:yyyy-MM-dd HH:mm:ss}", new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc).AddMilliseconds(app.CreateTime).ToLocalTime()));
                lvi.SubItems.Add(app.Status == -1 ? "已冻结" : (app.Status == 1 ? "正常" : "待审核"));
                AppInfoListView.Items.Add(lvi);
            }

        }
        public void loadShortList()
        {
            ShortListView.Items.Clear();
            ShortImpl impl = new ShortImpl();
            MsgEntity<PagerContainer<ShortInfo>> msg = impl.pager();
            if (msg.Code != 200)
            {
                return;
            }
            if (msg.Datas.Count < 1)
            {
                return;
            }

            foreach (ShortInfo line in msg.Datas.Data)
            {
                ListViewItem lvi = new ListViewItem();
                lvi.SubItems[0].Text = Convert.ToString(line.Id);
                lvi.SubItems.Add(line.ShortUrl);
                lvi.SubItems.Add(line.Url);
                lvi.SubItems.Add(Convert.ToString(line.Frequency));
                lvi.SubItems.Add(String.Format("{0:yyyy-MM-dd HH:mm:ss}", new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc).AddMilliseconds(line.CreateTime).ToLocalTime()));

                ShortListView.Items.Add(lvi);
            }

        }
        private void 创建应用ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AppEditForm appEditForm = new AppEditForm(this);
            appEditForm.ShowDialog();
        }

        private void 编辑应用ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String appId = null;
            try
            {
                appId = AppInfoListView.SelectedItems[0].SubItems[0].Text;
            }
            catch { }
            if (String.IsNullOrEmpty(appId)) {
                MessageBox.Show("请选择一条数据进行操作");
                return;
            }
            AppEditForm appEditForm = new AppEditForm(this, appId);
            appEditForm.ShowDialog();
        }

        private void 删除应用ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            String appId = null;
            try
            {
                appId = AppInfoListView.SelectedItems[0].SubItems[0].Text;
            }
            catch { }
            if (String.IsNullOrEmpty(appId))
            {
                MessageBox.Show("请选择一条数据进行操作");
                return;
            }
            AppImpl impl = new AppImpl();
            impl.del(appId);
            loadAppList();
        }

        private void 刷新列表ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            loadAppList();
        }

        private void 添加网址ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String unionId = null;
            try
            {
                unionId = AppInfoListView.SelectedItems[0].SubItems[2].Text;
            }
            catch { }
            if (String.IsNullOrEmpty(unionId))
            {
                MessageBox.Show("请选择一条数据进行操作");
                return;
            }
            ShorterForm shorterForm = new ShorterForm(this, unionId);
            shorterForm.ShowDialog();

        }

        private void 创建网址ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void 删除本行ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String shortId = null;
            try
            {
                shortId = ShortListView.SelectedItems[0].SubItems[0].Text;
            }
            catch { }
            if (String.IsNullOrEmpty(shortId))
            {
                MessageBox.Show("请选择一条数据进行操作");
                return;
            }
            ShortImpl impl = new ShortImpl();
            MsgEntity<String> msg = impl.del(long.Parse(shortId));
            if (msg.Code != 200)
            {
                MessageBox.Show(msg.Msg);
                return;
            }
            loadShortList();
        }

        private void 刷新列表ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            loadShortList();

        }

        private void 复制本行ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}
