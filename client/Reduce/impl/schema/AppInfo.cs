using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl.schema
{
    class AppInfo
    {
        private String id;

        public String Id
        {
            get { return id; }
            set { id = value; }
        }

        private String name;

        public String Name
        {
            get { return name; }
            set { name = value; }
        }

        private Int32 userId;

        public Int32 UserId
        {
            get { return userId; }
            set { userId = value; }
        }

        private String unionId;

        public String UnionId
        {
            get { return unionId; }
            set { unionId = value; }
        }

        private long createTime;

        public long CreateTime
        {
            get { return createTime; }
            set { createTime = value; }
        }

        /**
         * 状态 -1冻结 0待审核 1正常
         */
        private Int32 status;

        public Int32 Status
        {
            get { return status; }
            set { status = value; }
        }
    }
}
