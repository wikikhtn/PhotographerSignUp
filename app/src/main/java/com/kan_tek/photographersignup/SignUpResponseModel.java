package com.kan_tek.photographersignup;

import java.util.List;

/**
 * Created by WIKI on 29/10/2017.
 */

public class SignUpResponseModel {

    /**
     * statusCode : 201
     * message : You are Registered successfully.
     * data : {...}
     */

    private Integer statusCode;
    private String message;
    private DataBean data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 59f5cec1416a426e3d0c4c78
         * emailId : test1862@gmail.com
         * ssn : 3434
         * phoneNumber : 1231231234
         * deviceToken : 1
         * deviceType : ANDROID
         * accessToken : bfe18c6e18d44773ddcbf3730d7b647d
         * isVerified : auto
         * noOfTimesRated : 0
         * avgRatingValue : 0
         * totalRatingValue : 0
         * isAvailabilityBlocked : false
         * isAvailabilitySet : false
         * isProfileCompleted : false
         * isBlock : false
         * agentStatus : PENDING
         * isRegistered : true
         * portfolio : {"urls":[]}
         * funFact : null
         * registrationDate : 2017-10-29T12:51:13.927Z
         * equipmentAndBio : null
         * currentLocation : {"coordinates":[0,0],"type":"Point"}
         * location : {"coordinates":[0,0],"type":"Point"}
         * agentSaves : 0
         * agentPrice : 0
         * profileLastEdited : 2017-10-29T12:51:13.927Z
         * profilePicURL : {...}
         * documentsURL : {...}
         * backgroundCheck : true
         * dateOfBirth : 1991-01-25T00:00:00.000Z
         * defaultAvailability : {"Sunday":[],"Saturday":[],"Friday":[],"Thursday":[],"Wednesday":[],"Tuesday":[],"Monday":[]}
         * labels : [{"status":false,"label":"Featured"},{"status":false,"label":"Recommended"}]
         * agentEvents : []
         * address : null
         * name : {"firstName":"dfgdfg","lastName":"gdf"}
         * __v : 0
         * appVersion : {"isAppUpdate":false,"isForceUpdate":false}
         * eventList : [{"_id":"56a22d4c78ed84c04636d073","7}]
         */

        private String _id;
        private String emailId;
        private String ssn;
        private String phoneNumber;
        private String deviceToken;
        private String deviceType;
        private String accessToken;
        private String isVerified;
        private int noOfTimesRated;
        private int avgRatingValue;
        private int totalRatingValue;
        private boolean isAvailabilityBlocked;
        private boolean isAvailabilitySet;
        private boolean isProfileCompleted;
        private boolean isBlock;
        private String agentStatus;
        private boolean isRegistered;
        private PortfolioBean portfolio;
        private Object funFact;
        private String registrationDate;
        private Object equipmentAndBio;
        private CurrentLocationBean currentLocation;
        private LocationBean location;
        private int agentSaves;
        private int agentPrice;
        private String profileLastEdited;
        private ProfilePicURLBean profilePicURL;
        private DocumentsURLBean documentsURL;
        private boolean backgroundCheck;
        private String dateOfBirth;
        private DefaultAvailabilityBean defaultAvailability;
        private Object address;
        private NameBean name;
        private int __v;
        private AppVersionBean appVersion;
        private List<LabelsBean> labels;
        private List<?> agentEvents;
        private List<EventListBean> eventList;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getIsVerified() {
            return isVerified;
        }

        public void setIsVerified(String isVerified) {
            this.isVerified = isVerified;
        }

        public int getNoOfTimesRated() {
            return noOfTimesRated;
        }

        public void setNoOfTimesRated(int noOfTimesRated) {
            this.noOfTimesRated = noOfTimesRated;
        }

        public int getAvgRatingValue() {
            return avgRatingValue;
        }

        public void setAvgRatingValue(int avgRatingValue) {
            this.avgRatingValue = avgRatingValue;
        }

        public int getTotalRatingValue() {
            return totalRatingValue;
        }

        public void setTotalRatingValue(int totalRatingValue) {
            this.totalRatingValue = totalRatingValue;
        }

        public boolean isIsAvailabilityBlocked() {
            return isAvailabilityBlocked;
        }

        public void setIsAvailabilityBlocked(boolean isAvailabilityBlocked) {
            this.isAvailabilityBlocked = isAvailabilityBlocked;
        }

        public boolean isIsAvailabilitySet() {
            return isAvailabilitySet;
        }

        public void setIsAvailabilitySet(boolean isAvailabilitySet) {
            this.isAvailabilitySet = isAvailabilitySet;
        }

        public boolean isIsProfileCompleted() {
            return isProfileCompleted;
        }

        public void setIsProfileCompleted(boolean isProfileCompleted) {
            this.isProfileCompleted = isProfileCompleted;
        }

        public boolean isIsBlock() {
            return isBlock;
        }

        public void setIsBlock(boolean isBlock) {
            this.isBlock = isBlock;
        }

        public String getAgentStatus() {
            return agentStatus;
        }

        public void setAgentStatus(String agentStatus) {
            this.agentStatus = agentStatus;
        }

        public boolean isIsRegistered() {
            return isRegistered;
        }

        public void setIsRegistered(boolean isRegistered) {
            this.isRegistered = isRegistered;
        }

        public PortfolioBean getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(PortfolioBean portfolio) {
            this.portfolio = portfolio;
        }

        public Object getFunFact() {
            return funFact;
        }

        public void setFunFact(Object funFact) {
            this.funFact = funFact;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public Object getEquipmentAndBio() {
            return equipmentAndBio;
        }

        public void setEquipmentAndBio(Object equipmentAndBio) {
            this.equipmentAndBio = equipmentAndBio;
        }

        public CurrentLocationBean getCurrentLocation() {
            return currentLocation;
        }

        public void setCurrentLocation(CurrentLocationBean currentLocation) {
            this.currentLocation = currentLocation;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getAgentSaves() {
            return agentSaves;
        }

        public void setAgentSaves(int agentSaves) {
            this.agentSaves = agentSaves;
        }

        public int getAgentPrice() {
            return agentPrice;
        }

        public void setAgentPrice(int agentPrice) {
            this.agentPrice = agentPrice;
        }

        public String getProfileLastEdited() {
            return profileLastEdited;
        }

        public void setProfileLastEdited(String profileLastEdited) {
            this.profileLastEdited = profileLastEdited;
        }

        public ProfilePicURLBean getProfilePicURL() {
            return profilePicURL;
        }

        public void setProfilePicURL(ProfilePicURLBean profilePicURL) {
            this.profilePicURL = profilePicURL;
        }

        public DocumentsURLBean getDocumentsURL() {
            return documentsURL;
        }

        public void setDocumentsURL(DocumentsURLBean documentsURL) {
            this.documentsURL = documentsURL;
        }

        public boolean isBackgroundCheck() {
            return backgroundCheck;
        }

        public void setBackgroundCheck(boolean backgroundCheck) {
            this.backgroundCheck = backgroundCheck;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public DefaultAvailabilityBean getDefaultAvailability() {
            return defaultAvailability;
        }

        public void setDefaultAvailability(DefaultAvailabilityBean defaultAvailability) {
            this.defaultAvailability = defaultAvailability;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public NameBean getName() {
            return name;
        }

        public void setName(NameBean name) {
            this.name = name;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public AppVersionBean getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(AppVersionBean appVersion) {
            this.appVersion = appVersion;
        }

        public List<LabelsBean> getLabels() {
            return labels;
        }

        public void setLabels(List<LabelsBean> labels) {
            this.labels = labels;
        }

        public List<?> getAgentEvents() {
            return agentEvents;
        }

        public void setAgentEvents(List<?> agentEvents) {
            this.agentEvents = agentEvents;
        }

        public List<EventListBean> getEventList() {
            return eventList;
        }

        public void setEventList(List<EventListBean> eventList) {
            this.eventList = eventList;
        }

        public static class PortfolioBean {
            private List<?> urls;

            public List<?> getUrls() {
                return urls;
            }

            public void setUrls(List<?> urls) {
                this.urls = urls;
            }
        }

        public static class CurrentLocationBean {
            /**
             * coordinates : [0,0]
             * type : Point
             */

            private String type;
            private List<Integer> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Integer> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Integer> coordinates) {
                this.coordinates = coordinates;
            }
        }

        public static class LocationBean {
            /**
             * coordinates : [0,0]
             * type : Point
             */

            private String type;
            private List<Integer> coordinates;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Integer> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Integer> coordinates) {
                this.coordinates = coordinates;
            }
        }

        public static class ProfilePicURLBean {
            /**
             * thumb : http://photosesh.s3.amazonaws.com/profilePicture/thumb/Thumb_Profile_59f5cec1416a426e3d0c4c78.png?timestamp=1509281474
             * original : http://photosesh.s3.amazonaws.com/profilePicture/Profile_59f5cec1416a426e3d0c4c78.png?timestamp=1509281474
             */

            private String thumb;
            private String original;

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }
        }

        public static class DocumentsURLBean {
            /**
             * attorneyDocumentThumb :
             * attorneyDocument :
             * passportThumb :
             * passport :
             * drivingLicenseThumb :
             * drivingLicense :
             */

            private String attorneyDocumentThumb;
            private String attorneyDocument;
            private String passportThumb;
            private String passport;
            private String drivingLicenseThumb;
            private String drivingLicense;

            public String getAttorneyDocumentThumb() {
                return attorneyDocumentThumb;
            }

            public void setAttorneyDocumentThumb(String attorneyDocumentThumb) {
                this.attorneyDocumentThumb = attorneyDocumentThumb;
            }

            public String getAttorneyDocument() {
                return attorneyDocument;
            }

            public void setAttorneyDocument(String attorneyDocument) {
                this.attorneyDocument = attorneyDocument;
            }

            public String getPassportThumb() {
                return passportThumb;
            }

            public void setPassportThumb(String passportThumb) {
                this.passportThumb = passportThumb;
            }

            public String getPassport() {
                return passport;
            }

            public void setPassport(String passport) {
                this.passport = passport;
            }

            public String getDrivingLicenseThumb() {
                return drivingLicenseThumb;
            }

            public void setDrivingLicenseThumb(String drivingLicenseThumb) {
                this.drivingLicenseThumb = drivingLicenseThumb;
            }

            public String getDrivingLicense() {
                return drivingLicense;
            }

            public void setDrivingLicense(String drivingLicense) {
                this.drivingLicense = drivingLicense;
            }
        }

        public static class DefaultAvailabilityBean {
            private List<?> Sunday;
            private List<?> Saturday;
            private List<?> Friday;
            private List<?> Thursday;
            private List<?> Wednesday;
            private List<?> Tuesday;
            private List<?> Monday;

            public List<?> getSunday() {
                return Sunday;
            }

            public void setSunday(List<?> Sunday) {
                this.Sunday = Sunday;
            }

            public List<?> getSaturday() {
                return Saturday;
            }

            public void setSaturday(List<?> Saturday) {
                this.Saturday = Saturday;
            }

            public List<?> getFriday() {
                return Friday;
            }

            public void setFriday(List<?> Friday) {
                this.Friday = Friday;
            }

            public List<?> getThursday() {
                return Thursday;
            }

            public void setThursday(List<?> Thursday) {
                this.Thursday = Thursday;
            }

            public List<?> getWednesday() {
                return Wednesday;
            }

            public void setWednesday(List<?> Wednesday) {
                this.Wednesday = Wednesday;
            }

            public List<?> getTuesday() {
                return Tuesday;
            }

            public void setTuesday(List<?> Tuesday) {
                this.Tuesday = Tuesday;
            }

            public List<?> getMonday() {
                return Monday;
            }

            public void setMonday(List<?> Monday) {
                this.Monday = Monday;
            }
        }

        public static class NameBean {
            /**
             * firstName : dfgdfg
             * lastName : gdf
             */

            private String firstName;
            private String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }

        public static class AppVersionBean {
            /**
             * isAppUpdate : false
             * isForceUpdate : false
             */

            private boolean isAppUpdate;
            private boolean isForceUpdate;

            public boolean isIsAppUpdate() {
                return isAppUpdate;
            }

            public void setIsAppUpdate(boolean isAppUpdate) {
                this.isAppUpdate = isAppUpdate;
            }

            public boolean isIsForceUpdate() {
                return isForceUpdate;
            }

            public void setIsForceUpdate(boolean isForceUpdate) {
                this.isForceUpdate = isForceUpdate;
            }
        }

        public static class LabelsBean {
            /**
             * status : false
             * label : Featured
             */

            private boolean status;
            private String label;

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        }

        public static class EventListBean {
            /**
             * _id : 56a22d4c78ed84c04636d073
             * eventName : Casual_Events
             * eventDescription : Book for Birthdays, Showers, Engagements, Anniversaries, Bar/Bat Mitzvahs, or just random fun! Affordability is key. It now makes sense to hire a photographer to shoot at your casual get togethers. Just enjoy yourself!
             * eventImage : {"thumb":"http://photosesh.s3.amazonaws.com/profilePicture/thumb/Thumb_Profile_56a22d4c78ed84c04636d073.jpg","original":"http://photosesh.s3.amazonaws.com/profilePicture/Profile_56a22d4c78ed84c04636d073.jpg"}
             * eventStatus : true
             * __v : 0
             * order : 4
             */

            private String _id;
            private String eventName;
            private String eventDescription;
            private EventImageBean eventImage;
            private boolean eventStatus;
            private int __v;
            private int order;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getEventName() {
                return eventName;
            }

            public void setEventName(String eventName) {
                this.eventName = eventName;
            }

            public String getEventDescription() {
                return eventDescription;
            }

            public void setEventDescription(String eventDescription) {
                this.eventDescription = eventDescription;
            }

            public EventImageBean getEventImage() {
                return eventImage;
            }

            public void setEventImage(EventImageBean eventImage) {
                this.eventImage = eventImage;
            }

            public boolean isEventStatus() {
                return eventStatus;
            }

            public void setEventStatus(boolean eventStatus) {
                this.eventStatus = eventStatus;
            }

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public static class EventImageBean {
                /**
                 * thumb : http://photosesh.s3.amazonaws.com/profilePicture/thumb/Thumb_Profile_56a22d4c78ed84c04636d073.jpg
                 * original : http://photosesh.s3.amazonaws.com/profilePicture/Profile_56a22d4c78ed84c04636d073.jpg
                 */

                private String thumb;
                private String original;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getOriginal() {
                    return original;
                }

                public void setOriginal(String original) {
                    this.original = original;
                }
            }
        }
    }
}
