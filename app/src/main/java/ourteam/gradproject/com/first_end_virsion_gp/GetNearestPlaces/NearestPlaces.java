package ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces;

import java.util.List;

/**
 * Created by yasser ahmed on 6/14/2018.
 */

public class NearestPlaces {

    /**
     * html_attributions : []
     * results : [{"geometry":{"location":{"lat":-33.8693652,"lng":151.194084},"viewport":{"northeast":{"lat":-33.8681376697085,"lng":151.1955027302915},"southwest":{"lat":-33.8708356302915,"lng":151.1928047697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"6c49664eae2fd39063c4c4c163f94e60c52deab3","name":"CBA ATM","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":2293,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110640888053700474703/photos\">Jamie Gillespie<\/a>"],"photo_reference":"CmRaAAAAz0H8zSvyfa2ZtJU2DzTYKqJTqwVoTsQnee4eh2ngqYKZb9yXh_2NBAAIPYZZRNR-xSCOk1zygBJP9bnmwionrfnEJ84YKl1AFDdo0BH-2mSmgSsjDdHlaf8Ba90Euz91EhDD1-QDvL_yqyeJnuvQPrYeGhT3C63QnaDnmBeTI284q_bawV18tg","width":2808}],"place_id":"ChIJdfnCtjauEmsR7PVSGk5n5e4","rating":4.7,"reference":"CmRSAAAAagO1sv4SX-yAeNbV9dlmmW7zyCsskX2ZKBA2Wrct--XZzqrNo4deSiUDXGvDb37U3FVEqsuICvh7FlAKAXFHqq_6XyPsNJX6ZVRwbjtNN4wTNWvizIXtqpeRVdt8sr82EhBZ7hRjxz9AJJrp0MNXRzttGhTcxOlQaqQijBlMiceytrimdJydrQ","scope":"GOOGLE","types":["atm","bank","finance","point_of_interest","establishment"],"vicinity":"2 Union Street, Pyrmont"},{"geometry":{"location":{"lat":-33.8670521,"lng":151.194714},"viewport":{"northeast":{"lat":-33.8657037697085,"lng":151.1960636302915},"southwest":{"lat":-33.86840173029149,"lng":151.1933656697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"f0c9b826017907c966bbcbc210c74d2635b51bc4","name":"Cashcard ATM","opening_hours":{"open_now":true,"weekday_text":[]},"place_id":"ChIJty2saDauEmsRKfHriLiAQCk","reference":"CmRRAAAAJFl_72fAZ4zUKQJXrcaPujU5Ln19DceupCV_vNIgxpxpQEfq6UR3mu2YECYIs8Bl2jJ9SvJ0opiCznaGJhKD38z4VEGihGGuW4FE-kyw4S5fhQ7cU47Ln7bYUgedok_ZEhClalFSj_WfkUsB4uSjdu33GhQjDZgHYRwxkXYKPZXdKYaSEJEcBQ","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"2 Jones Bay Road, Pyrmont"},{"geometry":{"location":{"lat":-33.8697087,"lng":151.1973586},"viewport":{"northeast":{"lat":-33.8684512197085,"lng":151.1985905802915},"southwest":{"lat":-33.8711491802915,"lng":151.1958926197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"20b30765be97d304d9ca98f44fe94ef7656428d2","name":"Cashcard ATM","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3984,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/117324453790900281015/photos\">Evrem Yildiz<\/a>"],"photo_reference":"CmRaAAAAxzwh8DGkt_wxzlCniNYqynLzJ4MUPgkG2HYK44NCYw7W_zM8IeeoF_TPRMJLwixRGlmrBLAtDeb8kd0X-rw2RPxYY6TJcj9u2eVm2z6uxmoOcCEZigrbEAk4yzqhOUyIEhAlbiq9jV6T6Hzx3h2QRr2SGhS4H2iHyrqqX2lCbxbRXkq7TSl48A","width":2988}],"place_id":"ChIJ5SS4ODeuEmsRp_Mg8nA7mEg","rating":4,"reference":"CmRRAAAAR_HoED6VHyqiKwpQyaBXTKzmPntC73HpdpAP27-RUVLj-ghI992LtvgIXtW10IPY8SrbAs3aVX3debE7vj1JrQntpjQeSCiSMlCC7M_Nl_wzeeEfO8oGbniUFeBQrxPWEhD1N2_ndmmRhsbp0z_ptddXGhSKnUx31-OCk0mvvU-h4VbwHSfkrw","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"84 Union Street, Pyrmont"},{"geometry":{"location":{"lat":-33.87003170000001,"lng":151.1979322},"viewport":{"northeast":{"lat":-33.8686685697085,"lng":151.1992898802915},"southwest":{"lat":-33.8713665302915,"lng":151.1965919197085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"2edacec67d35deb98c1e68f7dd95ef34a6b702df","name":"NAB ATM","opening_hours":{"open_now":true,"weekday_text":[]},"photos":[{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114182739407198369642/photos\">Norman Pongracz<\/a>"],"photo_reference":"CmRaAAAApvdwiTA3crDxCQRr8fIszVIePinKdPOUACGlJvoYgFvJNrdooKsM7aWWbsCObU7T5GHaYHsZzgS6YFRUVrwXXdCYG_6jvZ_jsziELmoEdxuAGClWOrSsp3CSbG18-KJMEhDZQN1Qgzen8G9p-1UBEosoGhRSwofqYOBxNOIsUh1ktNcRV99bfg","width":4032}],"place_id":"ChIJq-IpszuuEmsRDL8PyvJYFP0","rating":2.2,"reference":"CmRSAAAAYanqAzFzgCCmlTDB_Typ2WhpnB_kwn3g4OlV9gJAlqfq2Pi5p5djaOfTYbT5JHtUjPGe4PAcfYcLqq2lMFvKXCYZKL1J6FSpSBbupCmHIYNvDp_pot5rmzwahA3JyUL_EhA7TuYVkUgud97grZ6oqpUMGhSTzhMrCnKTj_V7xGH2eP6nm-SnkQ","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"1-5 Darling Drive, Pyrmont"},{"geometry":{"location":{"lat":-33.8705655,"lng":151.1930026},"viewport":{"northeast":{"lat":-33.8690097697085,"lng":151.1942327302915},"southwest":{"lat":-33.8717077302915,"lng":151.1915347697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"7df85f8cbad9187982cff9bd2057bcc2feffdd6c","name":"Cashcard ATM","place_id":"ChIJARgn_TOuEmsRKi12r-bCcMA","reference":"CmRSAAAAdJSpuNb3m25XP7imECs33jKeOcl-0lqFWcYDFUh5BKBoTYOs3xQzrVfnzoIL4OEPOIj6D8k7It5Nowz2GGj01MUSZdqaSGZ2ZFfoDmrrBhxguRBreXrBiPmuqjXNdQCAEhBCReGRCym2f7bOgma_VtdXGhSm2APNW2BrKccBUGrjx8BMFycEuQ","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"63 Miller Street, Pyrmont"},{"geometry":{"location":{"lat":-33.8713406,"lng":151.1947406},"viewport":{"northeast":{"lat":-33.8699625197085,"lng":151.1961587302915},"southwest":{"lat":-33.8726604802915,"lng":151.1934607697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"27e9a3f7c0cd2628355f723e902059826a9de805","name":"Cashcard ATM","opening_hours":{"open_now":true,"weekday_text":[]},"place_id":"ChIJgQUnPTGuEmsRF8hsl9gkU1Q","reference":"CmRRAAAATr2J-fPVpox4B9L4gShzgphK9oSyoBO4q-b6wvzGjmhtTYqWH90pFN7Sm18zm3JKpq3E_Hv6cO7lEl_ChAKHeISvaD8EcGLxHGwZtL5ZTe9CQ0l27-qyWjPBjCHROF4zEhA986XL1bN8HT2UivswvLQKGhTrDe0PZaxkfE2kFHLo-Xw-Nofvuw","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"205 Harris Street, Pyrmont"},{"geometry":{"location":{"lat":-33.869628,"lng":151.1963347},"viewport":{"northeast":{"lat":-33.8683466697085,"lng":151.1976718302915},"southwest":{"lat":-33.8710446302915,"lng":151.1949738697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"e9f336187ce996c1ccf941645fe070daeb7f868b","name":"Commonwealth Bank ATM","place_id":"ChIJ2_9bIzeuEmsRgs-RTe4ndoU","reference":"CmRSAAAAWuKI9DVWcQdk3N42sTBrqlN80PJ-KBjhs2vZk2GXORRkUr-vA6_OVICh8fdrlYSQgO9FRbltgt1ohbTntQtClig5vkELmYlZ3q-el2vGNX28eH1QPm1iY-EdpULrGp6fEhBc3PloVsUQiPhh3oWVe6SpGhT54-l0vaaHYHVwA5G-Tx0_pSzoQA","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"50 Union Street, Pyrmont"},{"geometry":{"location":{"lat":-33.87048799999999,"lng":151.195773},"viewport":{"northeast":{"lat":-33.86917181970851,"lng":151.1970391302915},"southwest":{"lat":-33.8718697802915,"lng":151.1943411697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/shopping-71.png","id":"63e1378e655a5287a2f9b05d0bbb75d07b3330d3","name":"Pyrmont Express","opening_hours":{"open_now":false,"weekday_text":[]},"photos":[{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/102087671605708270094/photos\">Pyrmont Express<\/a>"],"photo_reference":"CmRaAAAA1BoWWkGClki2w30MX_LGrcr0Ioqb2SioWqFBLkSzRLcWJCNxhK3IjvJHnctFWKjn1upBcnWL2h4tgOnm6qKKL0-SZghKWh8dRMx8j3d3eLCmniD97lmCF17vCAud7vedEhCsSWW91yTmzX4DUYyMucnzGhT9DV2vEyHPRyM8An6Og6YlLqGZJQ","width":3024}],"place_id":"ChIJK2k21TCuEmsROroGVOv_9c4","rating":5,"reference":"CmRSAAAAXzunx6sY5rNHSZpTzImnTIW2BGRp8mgylUg_afzxC-B6woshegUUpxINpjhYQQccDxZY5qUEPUcxI_1_lK1POxk8Ev1RM21bvE4uz5WhcAWkxuV8l-OIdv8DgYyqgjr5EhDUBitqrJVROMiElWOrr_lnGhTD68AvQd_RnLFjmYGoUN00l3CiVg","scope":"GOOGLE","types":["grocery_or_supermarket","atm","convenience_store","finance","store","food","point_of_interest","establishment"],"vicinity":"2/104 Pyrmont Street, Pyrmont"},{"geometry":{"location":{"lat":-33.8705096,"lng":151.1986314},"viewport":{"northeast":{"lat":-33.8691853697085,"lng":151.1998818302915},"southwest":{"lat":-33.8718833302915,"lng":151.1971838697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png","id":"2849e6a9bf96a9b91e3d5aced7a3d74b15c245fb","name":"ATM","photos":[{"height":4048,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/106395258427521727618/photos\">Damian Duran<\/a>"],"photo_reference":"CmRaAAAA-F8nOhkHLhBEwxbbEm6mLyY2HMtDKkSVU0P9-mDBUReGTZOt9dZ17TiP9ajH4efZWdk_CcPDTsTFq3ZYDNvqTSlRWhtrpq_hv176tYEJnTscvSycxsVpAEaE_2vyIuFDEhAhY8mcK4faXpJ_dnPr1nQ6GhTy9m5wnfx3EDLBE5vV_gnqb131Lg","width":3036}],"place_id":"ChIJK06l4jmuEmsRIc-xZ6oKX14","reference":"CmRRAAAAn8-a67FC_DidgEXAj4jujDJwu9ncG7SjglaBeCn1mmHB72k7qeXFoq-oBzUmTKOHNtLuClSBi8lbTkZzQJlsTCNJtD2gPfsqINECy6k9VM-yb57wsHHSgaMK5d_w_4AKEhCxiYTyLpZ18FeV7RJgh41PGhR3sJZnUhJh6suyuijiMe87Mqxs2g","scope":"GOOGLE","types":["atm","finance","point_of_interest","establishment"],"vicinity":"1A Darling Drive, Sydney"}]
     * status : OK
     */

    private String status;
    private List<?> html_attributions;
    private List<ResultsBean> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * geometry : {"location":{"lat":-33.8693652,"lng":151.194084},"viewport":{"northeast":{"lat":-33.8681376697085,"lng":151.1955027302915},"southwest":{"lat":-33.8708356302915,"lng":151.1928047697085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/atm-71.png
         * id : 6c49664eae2fd39063c4c4c163f94e60c52deab3
         * name : CBA ATM
         * opening_hours : {"open_now":true,"weekday_text":[]}
         * photos : [{"height":2293,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110640888053700474703/photos\">Jamie Gillespie<\/a>"],"photo_reference":"CmRaAAAAz0H8zSvyfa2ZtJU2DzTYKqJTqwVoTsQnee4eh2ngqYKZb9yXh_2NBAAIPYZZRNR-xSCOk1zygBJP9bnmwionrfnEJ84YKl1AFDdo0BH-2mSmgSsjDdHlaf8Ba90Euz91EhDD1-QDvL_yqyeJnuvQPrYeGhT3C63QnaDnmBeTI284q_bawV18tg","width":2808}]
         * place_id : ChIJdfnCtjauEmsR7PVSGk5n5e4
         * rating : 4.7
         * reference : CmRSAAAAagO1sv4SX-yAeNbV9dlmmW7zyCsskX2ZKBA2Wrct--XZzqrNo4deSiUDXGvDb37U3FVEqsuICvh7FlAKAXFHqq_6XyPsNJX6ZVRwbjtNN4wTNWvizIXtqpeRVdt8sr82EhBZ7hRjxz9AJJrp0MNXRzttGhTcxOlQaqQijBlMiceytrimdJydrQ
         * scope : GOOGLE
         * types : ["atm","bank","finance","point_of_interest","establishment"]
         * vicinity : 2 Union Street, Pyrmont
         */

        private GeometryBean geometry;
        private String icon;
        private String id;
        private String name;
        private OpeningHoursBean opening_hours;
        private String place_id;
        private double rating;
        private String reference;
        private String scope;
        private String vicinity;
        private List<PhotosBean> photos;
        private List<String> types;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpening_hours() {
            return opening_hours;
        }

        public void setOpening_hours(OpeningHoursBean opening_hours) {
            this.opening_hours = opening_hours;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":-33.8693652,"lng":151.194084}
             * viewport : {"northeast":{"lat":-33.8681376697085,"lng":151.1955027302915},"southwest":{"lat":-33.8708356302915,"lng":151.1928047697085}}
             */

            private LocationBean location;
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : -33.8693652
                 * lng : 151.194084
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":-33.8681376697085,"lng":151.1955027302915}
                 * southwest : {"lat":-33.8708356302915,"lng":151.1928047697085}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : -33.8681376697085
                     * lng : 151.1955027302915
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : -33.8708356302915
                     * lng : 151.1928047697085
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class OpeningHoursBean {
            /**
             * open_now : true
             * weekday_text : []
             */

            private boolean open_now;
            private List<?> weekday_text;

            public boolean isOpen_now() {
                return open_now;
            }

            public void setOpen_now(boolean open_now) {
                this.open_now = open_now;
            }

            public List<?> getWeekday_text() {
                return weekday_text;
            }

            public void setWeekday_text(List<?> weekday_text) {
                this.weekday_text = weekday_text;
            }
        }

        public static class PhotosBean {
            /**
             * height : 2293
             * html_attributions : ["<a href=\"https://maps.google.com/maps/contrib/110640888053700474703/photos\">Jamie Gillespie<\/a>"]
             * photo_reference : CmRaAAAAz0H8zSvyfa2ZtJU2DzTYKqJTqwVoTsQnee4eh2ngqYKZb9yXh_2NBAAIPYZZRNR-xSCOk1zygBJP9bnmwionrfnEJ84YKl1AFDdo0BH-2mSmgSsjDdHlaf8Ba90Euz91EhDD1-QDvL_yqyeJnuvQPrYeGhT3C63QnaDnmBeTI284q_bawV18tg
             * width : 2808
             */

            private int height;
            private String photo_reference;
            private int width;
            private List<String> html_attributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getHtml_attributions() {
                return html_attributions;
            }

            public void setHtml_attributions(List<String> html_attributions) {
                this.html_attributions = html_attributions;
            }
        }
    }
}

