using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl.schema
{
    class ShortInfo
    {

        private Int32 id;

        public Int32 Id
        {
            get { return id; }
            set { id = value; }
        }

        private Int32 userId;

        public Int32 UserId
        {
            get { return userId; }
            set { userId = value; }
        }

        private String shortUrl;

        public String ShortUrl
        {
            get { return shortUrl; }
            set { shortUrl = value; }
        }

        private String url;

        public String Url
        {
            get { return url; }
            set { url = value; }
        
        }

        private Int32 frequency;

        public Int32 Frequency
        {
            get { return frequency; }
            set { frequency = value; }
        }

        private long createTime;

        public long CreateTime
        {
            get { return createTime; }
            set { createTime = value; }
        }


    }
}
